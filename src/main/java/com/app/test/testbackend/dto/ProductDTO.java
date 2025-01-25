package com.app.test.testbackend.dto;

import com.app.test.testbackend.persistence.entity.Category;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Category category;
}
