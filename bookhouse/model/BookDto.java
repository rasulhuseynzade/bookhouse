package com.example.bookhouse.model;

import com.example.bookhouse.dao.AuthorEntity;
import com.example.bookhouse.enums.Currency;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class BookDto {
    private Long id;
    private String name;
    private String author;
    private BigDecimal price;
    private Currency currency;
    private String section;
    private String genre;
    List<AuthorEntity> authorEntity;
    private LocalDate originDate;
    private LocalDateTime createAt;
}
