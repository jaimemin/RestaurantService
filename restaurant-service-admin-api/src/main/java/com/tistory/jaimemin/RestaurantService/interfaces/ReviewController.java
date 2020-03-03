package com.tistory.jaimemin.RestaurantService.interfaces;

import com.tistory.jaimemin.RestaurantService.application.ReviewService;
import com.tistory.jaimemin.RestaurantService.domain.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping("/reviews")
    public List<Review> reviews() {
        List<Review> reviews = reviewService.getReviews();

        return reviews;
    }

}
