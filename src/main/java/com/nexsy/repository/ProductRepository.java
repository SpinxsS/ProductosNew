package com.nexsy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nexsy.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	boolean existsById(Long id);
}