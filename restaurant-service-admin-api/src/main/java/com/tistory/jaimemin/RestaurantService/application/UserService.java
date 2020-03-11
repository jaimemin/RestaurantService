package com.tistory.jaimemin.RestaurantService.application;

import com.tistory.jaimemin.RestaurantService.domain.User;
import com.tistory.jaimemin.RestaurantService.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        List<User> users = userRepository.findAll();

        return users;
    }

    public User addUser(String email, String name) {
        User user = User.builder()
                .email(email)
                .name(name)
                .level(1L)
                .build();

        return userRepository.save(user);
    }

    public User updateUser(Long id, String email
            , String name, Long level) {
        // TODO: restaurantService의 예외 처리 참고
        User user = userRepository
                .findById(id)
                .orElse(null);
        user.setEmail(email);
        user.setName(name);
        user.setLevel(level);

        return user;
    }

    public User deActivateUser(Long id) {
        // TODO: 실제로 작업 필요
        User user = userRepository
                .findById(id)
                .orElse(null);
        user.deActivate();

        return user;
    }
}
