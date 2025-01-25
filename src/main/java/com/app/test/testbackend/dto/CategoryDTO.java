package com.app.test.testbackend.dto;

import java.util.ArrayList;
import java.util.List;

import com.app.test.testbackend.persistence.entity.Product;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryDTO {
    private Long id;
    private String name;
    private List<Product> products = new ArrayList<>();
}
