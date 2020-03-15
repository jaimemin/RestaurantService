package com.tistory.jaimemin.RestaurantService.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

public class JwtUtil {
    private Key key;

    public JwtUtil(String secret) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
    }

    public String createToken(long userId, String name, Long restaurantId) {
        JwtBuilder jwtBuilder = Jwts
                .builder()
                .claim("userId", userId)
                .claim("name", name);

        if (restaurantId != null) {
            jwtBuilder = jwtBuilder.claim("restaurantId", restaurantId);
        }

        return jwtBuilder
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public Claims getClaims(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(token)
                .getBody();

        return claims;
    }
}
