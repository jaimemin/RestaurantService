package com.tistory.jaimemin.RestaurantService.application;

import com.tistory.jaimemin.RestaurantService.domain.Category;
import com.tistory.jaimemin.RestaurantService.domain.CategoryRepository;
import com.tistory.jaimemin.RestaurantService.domain.Region;
import com.tistory.jaimemin.RestaurantService.domain.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategories() {
        List<Category> categories = categoryRepository.findAll();

        return categories;
    }

    public Category addCategory(String name) {
        Category category = Category.builder().name(name).build();
        categoryRepository.save(category);

        return category;
    }
}
