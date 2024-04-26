package com.villancio.villanciomarket.domain.repository;

import java.util.List;
import java.util.Optional;

import com.villancio.villanciomarket.domain.model.Product;

public interface ProductRepository {
    List<Product> getAll();
    Optional<List<Product>> getByCategory(Integer categoryId); 
    Optional<List<Product>> getScarseProducts(Integer quantity);
    Optional<List<Product>> getProduct(Integer productId);
    Product save(Product product);
    void delete(Integer product);

}
