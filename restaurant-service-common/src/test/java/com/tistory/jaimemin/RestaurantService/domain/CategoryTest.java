package com.tistory.jaimemin.RestaurantService.domain;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CategoryTest {

    @Test
    public void create() {
        Category category = Category.builder().name("Korean Food").build();

        assertThat(category.getName(), is("Korean Food"));
    }
}