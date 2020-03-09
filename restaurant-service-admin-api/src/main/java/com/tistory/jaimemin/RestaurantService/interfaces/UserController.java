package com.tistory.jaimemin.RestaurantService.interfaces;

import com.tistory.jaimemin.RestaurantService.application.UserService;
import com.tistory.jaimemin.RestaurantService.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class UserController {
    // 1. User List
    // 2. User Create -> 회원 가입
    // 3. User Update
    // 4. User Delete
    // - level: 0 => 아무것도 못함
    // - level: 1 => customer
    // - level: 2 => restaurant owner
    // - level: 3 => admin
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getUsers() {
        List<User> users = userService.getUsers();

        return users;
    }

    @PostMapping("/users")
    public ResponseEntity<?> create(@RequestBody User resource) throws URISyntaxException {
        String email = resource.getEmail();
        String name = resource.getName();
        User user = userService.addUser(email, name);

        String url = "/users/" + user.getId();

        return ResponseEntity
                .created(new URI(url))
                .body("{}");
    }
}
