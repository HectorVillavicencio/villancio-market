package com.villancio.villanciomarket.persistence;

 

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.villancio.villanciomarket.domain.model.Product;
import com.villancio.villanciomarket.domain.repository.ProductRepository;
import com.villancio.villanciomarket.persistence.crud.ProductCrudRepository;
import com.villancio.villanciomarket.persistence.entity.ProductEntity;
import com.villancio.villanciomarket.persistence.mapper.ProductMapper;

@Repository
public class ProductRepostory implements ProductRepository{
    @Autowired
    private ProductCrudRepository productCrudRepository;

    @Autowired
    private ProductMapper mapper;

    public List<Product> getAll(){
        List<ProductEntity> products = (List<ProductEntity>) productCrudRepository.findAll();
        return mapper.toProducts(products);
    }

    @Override
    public Optional<List<Product>> getByCategory(Integer idCategory){
        List<ProductEntity> products = productCrudRepository.findByIdCategoryOrderByNameAsc(idCategory);
        return Optional.of(mapper.toProducts(products));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(Integer quantity){
        Optional<List<ProductEntity>> products = productCrudRepository.findByStockQuantityLessThanAndState(quantity, true);
        return products.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(Integer idProduct){
        return productCrudRepository.findById(idProduct).map(producto -> mapper.toProduct(producto));
    }

    @Override
    public Product save(Product product){
        ProductEntity productEntity = mapper.toProductEntity(product);
        return mapper.toProduct(productCrudRepository.save(productEntity));
    }

    @Override
    public void delete(Integer idProduct){
        productCrudRepository.deleteById(idProduct);
    }
}
