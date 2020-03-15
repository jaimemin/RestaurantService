package com.tistory.jaimemin.RestaurantService.interfaces;

import lombok.Data;

@Data
public class SessionRequestDto {
    private String email;
    private String password;
}
