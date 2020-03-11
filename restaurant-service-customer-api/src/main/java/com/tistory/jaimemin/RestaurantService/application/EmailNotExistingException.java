package com.tistory.jaimemin.RestaurantService.application;

public class EmailNotExistingException extends RuntimeException{
    EmailNotExistingException(String email) {
        super("Email is not registered: " + email);
    }
}
