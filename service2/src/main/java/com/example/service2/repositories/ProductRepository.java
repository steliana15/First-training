package com.example.service2.repositories;

import com.example.service2.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<Product, Integer> {
}

