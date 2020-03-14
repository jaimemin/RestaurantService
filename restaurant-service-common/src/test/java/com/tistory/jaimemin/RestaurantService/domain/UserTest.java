package com.tistory.jaimemin.RestaurantService.domain;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void create() {
        User user = User.builder()
                .email("test@example.com")
                .name("tester")
                .level(100L)
                .build();

        assertThat(user.getName(), is("tester"));
        assertThat(user.isAdmin(), is(true));
        assertThat(user.isActive(), is(true));

        user.deActivate();

        assertThat(user.isActive(), is(false));
    }

}