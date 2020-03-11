package com.tistory.jaimemin.RestaurantService.interfaces;

import com.tistory.jaimemin.RestaurantService.application.UserService;
import com.tistory.jaimemin.RestaurantService.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class SessionController {
    @Autowired
    private UserService userService;

    @PostMapping("/session")
    public ResponseEntity<SessionResponseDto> create(@RequestBody SessionRequestDto resource)
            throws URISyntaxException {
        String email = resource.getEmail();
        String password = resource.getPassword();
        String url = "/session";

        User user = userService.authenticate(email, password);
        String accessToken = user.getAccessToken();

        return ResponseEntity
                .created(new URI(url))
                .body(SessionResponseDto
                        .builder()
                        .accessToken(accessToken)
                        .build());
    }
}
