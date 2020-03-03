package com.tistory.jaimemin.RestaurantService.application;

import com.tistory.jaimemin.RestaurantService.application.ReviewService;
import com.tistory.jaimemin.RestaurantService.domain.Review;
import com.tistory.jaimemin.RestaurantService.domain.ReviewRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

public class ReviewServiceTest {
    private ReviewService reviewService;

    @Mock
    private ReviewRepository reviewRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        reviewService = new ReviewService(reviewRepository);
    }

    @Test
    public void addReview() {
        Review review = Review.builder()
                .name("Gudetama")
                .score(3)
                .description("delicious")
                .build();

        reviewService.addReview(1004L, review);

        verify(reviewRepository).save(any());
    }
}