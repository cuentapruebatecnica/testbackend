package com.app.test.testbackend.persistence.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.test.testbackend.persistence.dao.ICategoryDAO;
import com.app.test.testbackend.persistence.entity.Category;
import com.app.test.testbackend.persistence.repository.CategoryRepository;

@Component
public class CategoryDAOImpl implements ICategoryDAO {

    @Autowired
    private CategoryRepository repository;

    @Override
    public List<Category> findAll() {
       return (List<Category>) repository.findAll();
    }

    @Override
    public Category save(Category category) {
       return repository.save(category);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Category> findById(Long id) {
        return repository.findById(id);
    }
    
}
