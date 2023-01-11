package com.oxy.microservice.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oxy.microservice.productservice.dto.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
}