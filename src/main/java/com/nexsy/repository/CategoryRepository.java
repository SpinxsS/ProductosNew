package com.nexsy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nexsy.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
