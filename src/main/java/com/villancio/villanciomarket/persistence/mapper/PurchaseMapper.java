package com.villancio.villanciomarket.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.villancio.villanciomarket.domain.model.Purchase;
import com.villancio.villanciomarket.persistence.entity.PuchaseEntity;

@Mapper(componentModel = "spring", uses = { PurchaseItemMapper.class})
public interface PurchaseMapper {

    @Mappings({
        @Mapping(source = "idPuchase", target = "purchaseId"),
        @Mapping(source = "idClient", target = "clienteId"),
        @Mapping(source = "comment", target = "comment"),
        @Mapping(source = "products", target = "item")
    })
    Purchase toPurchase(PuchaseEntity puchaseEntity);
    List<Purchase> toPurchases(Iterable<PuchaseEntity> iterable);
    
    @InheritInverseConfiguration
    @Mapping(target = "client", ignore= true)
    PuchaseEntity toPuchaseEntity(Purchase purchase);

}
