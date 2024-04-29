package com.villancio.villanciomarket.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.villancio.villanciomarket.domain.model.Product;
import com.villancio.villanciomarket.persistence.entity.ProductEntity;

@Mapper(componentModel = "spring", uses ={CategoryMapper.class})
public interface ProductMapper {

    @Mappings({
        @Mapping(source = "idProduct", target = "idProduct"),
        @Mapping(source = "name", target = "name"),
        @Mapping(source = "idCategory", target = "idCategory"),
        @Mapping(source = "sellPrice", target = "sellPrice"),
        @Mapping(source = "stockQuantity", target = "stockQuantity"),
        @Mapping(source = "state", target = "state"),
        @Mapping(source = "category", target = "category")
    })
    Product toProduct(ProductEntity producto);
    List<Product> toProducts(List<ProductEntity> products);

    @InheritInverseConfiguration
    @Mapping(target = "barcode", ignore = true)
    ProductEntity toProductEntity(Product product);

}   
