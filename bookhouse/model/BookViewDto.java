package com.example.bookhouse.model;

import com.example.bookhouse.dao.AuthorEntity;
import com.example.bookhouse.enums.Currency;
import jakarta.validation.constraints.Min;
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
public class BookViewDto {
    private Long id;
    @NotBlank
    private String name;
    @PositiveOrZero
    @Min(value = 5, message = "It cannot be less than 5")
    private BigDecimal price;
    private Currency currency;
    private String section;
    private String genre;
    private LocalDate originDate;
    private LocalDateTime createAt;
    private AuthorViewDto author;
    private List<CommentDto> comments;
    private List<MeetingViewDto> meetings;
}
