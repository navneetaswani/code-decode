package com.oxy.microservice.productservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oxy.microservice.productservice.dto.Product;
import com.oxy.microservice.productservice.repository.ProductRepository;

@Service
public class ProductService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private ProductRepository productRepository;

	@Autowired
	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public Iterable<Product> listAllProducts() {
		logger.debug("listAllProducts called");
		return productRepository.findAll();
	}

	public Product getProductById(Integer id) {
		logger.debug("getProductById called");
		return productRepository.findById(id).orElse(null);
	}

	public Product saveProduct(Product product) {
		logger.debug("saveProduct called");
		return productRepository.save(product);
	}

	public void deleteProduct(Integer id) {
		logger.debug("deleteProduct called");
		productRepository.deleteById(id);
	}
}