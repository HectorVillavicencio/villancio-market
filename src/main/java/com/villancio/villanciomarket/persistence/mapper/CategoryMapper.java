package com.villancio.villanciomarket.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.villancio.villanciomarket.domain.model.Category;
import com.villancio.villanciomarket.persistence.entity.CategoryEntity;



@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mappings({
        @Mapping(source = "idCategory", target = "categoryId"),
        @Mapping(source = "description", target = "category"),
        @Mapping(source = "state", target = "active"),
    })
    Category toCategory(CategoryEntity categoryEntity);

    @InheritInverseConfiguration
    @Mapping(target = "products", ignore = true)
    CategoryEntity toCategoryEntity(Category category);



}
