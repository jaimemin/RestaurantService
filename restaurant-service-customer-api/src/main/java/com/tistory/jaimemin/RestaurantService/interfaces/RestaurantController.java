package com.tistory.jaimemin.RestaurantService.interfaces;

import com.tistory.jaimemin.RestaurantService.application.RestaurantService;
import com.tistory.jaimemin.RestaurantService.domain.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@CrossOrigin
@RestController
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public List<Restaurant> restaurants() {
        List<Restaurant> restaurants = restaurantService.getRestaurants();

        return restaurants;
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant restaurant(@PathVariable Long id) {
        // 기본 정보 + 메뉴 정보
        Restaurant restaurant = restaurantService.getRestaurant(id);

        return restaurant;
    }

}
