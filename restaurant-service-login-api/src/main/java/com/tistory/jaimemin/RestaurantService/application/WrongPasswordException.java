package com.tistory.jaimemin.RestaurantService.application;

public class WrongPasswordException extends RuntimeException{
    WrongPasswordException() {
        super("wrong password");
    }
}
