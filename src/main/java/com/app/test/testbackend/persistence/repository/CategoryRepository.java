package com.app.test.testbackend.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.test.testbackend.persistence.entity.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

}
