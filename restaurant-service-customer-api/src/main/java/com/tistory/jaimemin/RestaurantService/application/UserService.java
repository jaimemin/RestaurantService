package com.tistory.jaimemin.RestaurantService.application;

import com.tistory.jaimemin.RestaurantService.domain.User;
import com.tistory.jaimemin.RestaurantService.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    UserRepository userRepository;

    PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository
            , PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(String email, String name, String password) {
        Optional<User> isExisting = userRepository.findByEmail(email);

        if (isExisting.isPresent()) {
            throw new EmailExistingException(email);
        }

        String encodedPassword = passwordEncoder.encode(password);

        User user = User.builder()
                .email(email)
                .name(name)
                .password(encodedPassword)
                .level(1L)
                .build();

        return userRepository.save(user);
    }

    public User authenticate(String email, String password) {
        User user = userRepository
                .findByEmail(email)
                .orElseThrow(() -> new EmailNotExistingException(email));

        if (passwordEncoder.matches(password, user.getPassword()) == false) {
            throw new WrongPasswordException();
        }

        return user;
    }

}
