package com.app.test.testbackend.service;

import java.util.List;
import java.util.Optional;

import com.app.test.testbackend.persistence.entity.Category;

public interface ICategoryService {
    List<Category> findAll();
    Category save(Category category);
    Optional<Category> findById(Long id);
    void deleteById(Long id);
}
