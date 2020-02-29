package com.tistory.jaimemin.RestaurantService.domain;

import java.util.List;

public interface RestaurantRepository {
    List<Restaurant> findAll();

    Restaurant findById(Long id);

    Restaurant saveRestaurant(Restaurant restaurant);
}
