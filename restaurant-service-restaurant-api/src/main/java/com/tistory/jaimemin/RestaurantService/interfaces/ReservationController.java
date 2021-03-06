package com.tistory.jaimemin.RestaurantService.interfaces;

import com.tistory.jaimemin.RestaurantService.application.ReservationService;
import com.tistory.jaimemin.RestaurantService.domain.Reservation;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/reservations")
    public List<Reservation> getReservations(Authentication authentication) {
        Claims claims = (Claims) authentication.getPrincipal();
        Long restaurantId = claims.get("restaurantId", Long.class);
        List<Reservation> reservations = reservationService.getReservations(restaurantId);

        return reservations;
    }
}
