package com.villancio.villanciomarket.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.villancio.villanciomarket.domain.model.PurchaseItem;
import com.villancio.villanciomarket.persistence.entity.ProductPuchaseEntity;

@Mapper(componentModel = "spring", uses ={ProductMapper.class})
public interface PurchaseItemMapper {
    
    @Mappings({
        @Mapping(source = "id.idproduct", target = "productId"),
        @Mapping(source = "cant", target = "quantity"),
        @Mapping(source = "total", target = "total"),
        @Mapping(source = "state", target = "active")
    })
    PurchaseItem toPurchaseItem(ProductPuchaseEntity product);

    @InheritInverseConfiguration
    @Mappings({
        @Mapping(target = "puchase", ignore = true),
        @Mapping(target = "product", ignore = true),
        @Mapping(target = "id.idPuchase", ignore = true)
    })
    ProductPuchaseEntity toProductPuchaseEntity (PurchaseItem item);
}
