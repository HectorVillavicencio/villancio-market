package com.villancio.villanciomarket.domain.model;

import com.villancio.villanciomarket.persistence.entity.CategoryEntity;

import lombok.*;

@Setter
@Getter
public class Product {

    private Integer idProduct;
    private String name;
    private Integer idCategory;
    private Double sellPrice;
    private Integer stockQuantity;
    private Boolean state;
    private CategoryEntity category;
}


