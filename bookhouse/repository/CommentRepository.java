package com.example.bookhouse.repository;

import com.example.bookhouse.dao.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
}
