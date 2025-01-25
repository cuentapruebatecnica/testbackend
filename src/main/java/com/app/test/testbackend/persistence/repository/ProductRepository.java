package com.app.test.testbackend.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.test.testbackend.persistence.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    
}
