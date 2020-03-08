package com.tistory.jaimemin.RestaurantService.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    List<Category> findAll();

    Category save(Category category);
}
