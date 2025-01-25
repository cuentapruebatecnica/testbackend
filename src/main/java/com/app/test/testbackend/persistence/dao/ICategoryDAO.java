package com.app.test.testbackend.persistence.dao;

import java.util.List;
import java.util.Optional;

import com.app.test.testbackend.persistence.entity.Category;

public interface ICategoryDAO {
    List<Category> findAll();
    Category save(Category category);
    void deleteById(Long id);
    Optional<Category> findById(Long id);
}
