package com.duartqx.alison_spring_1.service;

import com.duartqx.alison_spring_1.entity.Product;
import com.duartqx.alison_spring_1.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findByNameIn(List<String> names) {
        return productRepository.findByNameIn(names);
    }

    public List<Product> all(List<String> names) {
        return productRepository.findAll();
    }

    public Product create(Product product) {
        return productRepository.save(product);
    }
}
