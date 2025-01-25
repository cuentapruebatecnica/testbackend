package com.app.test.testbackend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.test.testbackend.persistence.dao.ICategoryDAO;
import com.app.test.testbackend.persistence.entity.Category;
import com.app.test.testbackend.service.ICategoryService;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private ICategoryDAO dao;

    @Override
    public List<Category> findAll() {
        return (List<Category>) dao.findAll();
    }

    @Override
    public Category save(Category category) {
        return dao.save(category);
    }

    @Override
    public Optional<Category> findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        dao.deleteById(id);
    }
}
