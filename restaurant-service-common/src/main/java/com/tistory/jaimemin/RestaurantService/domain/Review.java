package com.tistory.jaimemin.RestaurantService.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    @Id
    @GeneratedValue
    private Long id;

    @Setter
    private Long restaurantId;

    @NotEmpty
    private String name;

    @Min(1)
    @Max(5)
    private Integer score;

    @NotEmpty
    private String description;
}
