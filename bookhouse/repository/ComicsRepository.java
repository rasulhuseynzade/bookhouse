package com.example.bookhouse.repository;

import com.example.bookhouse.dao.ComicsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComicsRepository extends JpaRepository<ComicsEntity, Long> {
}
