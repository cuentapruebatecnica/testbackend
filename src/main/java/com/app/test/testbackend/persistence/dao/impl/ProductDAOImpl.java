package com.app.test.testbackend.persistence.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.test.testbackend.persistence.dao.IProductDAO;
import com.app.test.testbackend.persistence.entity.Product;
import com.app.test.testbackend.persistence.repository.ProductRepository;

@Component
public class ProductDAOImpl implements IProductDAO{

    @Autowired
    private ProductRepository repository;

    @Override
    public List<Product> findAll() {
      return (List<Product>) repository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Product save(Product product) {
      return repository.save(product);
    }

    @Override
    public void deleteById(Long id) {
      repository.deleteById(id);
    }

}
