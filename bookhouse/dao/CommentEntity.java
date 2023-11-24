package com.example.bookhouse.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String message;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private BookEntity bookEntity;
    @CreationTimestamp
    private LocalDateTime created_at;
//    @UpdateTimestamp
//    private LocalDateTime updatedAt;
}
