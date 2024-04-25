package com.villancio.villanciomarket.persistence;

 

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.villancio.villanciomarket.persistence.crud.ProductCrudRepository;
import com.villancio.villanciomarket.persistence.entity.ProductEntity;

@Repository
public class ProductRepostory {
    private ProductCrudRepository productCrudRepository;

    public List<ProductEntity> getAll(){
        return (List<ProductEntity>) productCrudRepository.findAll();
    }

    public List<ProductEntity> getByCategory(Integer idCategory){
        return productCrudRepository.findByIdCategoryOrderByNameAsc(idCategory);
    }

    public Optional<List<ProductEntity>> getfew(Integer amount){
        return productCrudRepository.findByStockQuantityLessThanAndState(amount, true);
    }

    public Optional<ProductEntity> getProduct(Integer idProduct){
        return productCrudRepository.findById(idProduct);
    }

    public ProductEntity save(ProductEntity product){
        return productCrudRepository.save(product);
    }

    public void delete(Integer idProduct){
        productCrudRepository.deleteById(idProduct);
    }
}
