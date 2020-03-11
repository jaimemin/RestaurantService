package com.tistory.jaimemin.RestaurantService.application;

public class EmailExistingException extends RuntimeException {

    EmailExistingException(String email) {
        super("Email was already registered: " + email);
    }
}
