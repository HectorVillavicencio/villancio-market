package com.villancio.villanciomarket.persistence.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.villancio.villanciomarket.persistence.entity.ProductEntity;

public interface ProductCrudRepository extends CrudRepository<ProductEntity, Integer>{

    List<ProductEntity> findByIdCategoryOrderByNameAsc(Integer idCategory);
    Optional<List<ProductEntity>> findByStockQuantityLessThanAndState(Integer stockQuantity, boolean state);
}
