package com.app.test.testbackend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.test.testbackend.persistence.dao.IProductDAO;
import com.app.test.testbackend.persistence.entity.Product;
import com.app.test.testbackend.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService{

    @Autowired
    private IProductDAO dao;

    @Override
    public List<Product> findAll() {
        return (List<Product>) dao.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public Product save(Product product) {
        return dao.save(product);
    }

    @Override
    public void deleteById(Long id) {
        dao.deleteById(id);
    }

}
