package com.example.bookhouse.model;

import com.example.bookhouse.enums.Currency;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ComicsViewDto {
    private Long id;
    private String name;
    private String category;
    private String ISBN;
    private String vol;
    private int numberOfPages;
    private LocalDate publicationDate;
    private Currency currency;
    @PositiveOrZero
    @Min(value = 5, message = "It cannot be less than 5")
    private BigDecimal price;
    private LocalDateTime createdAt;
}
