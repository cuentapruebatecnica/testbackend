package com.app.test.testbackend.service;

import java.util.List;
import java.util.Optional;

import com.app.test.testbackend.persistence.entity.Product;

public interface IProductService {
    List<Product> findAll();
    Optional<Product> findById(Long id);
    Product save(Product product);
    void deleteById(Long id);
}
