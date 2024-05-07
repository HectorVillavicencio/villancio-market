package com.villancio.villanciomarket.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.villancio.villanciomarket.domain.model.Purchase;
import com.villancio.villanciomarket.domain.repository.PurchaseRepository;
import com.villancio.villanciomarket.persistence.crud.PurchaseCrudRepository;
import com.villancio.villanciomarket.persistence.entity.PuchaseEntity;
import com.villancio.villanciomarket.persistence.mapper.PurchaseMapper;

public class CompraRepository implements PurchaseRepository{
    @Autowired
    private PurchaseCrudRepository purchaseCrudRepository;

    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases(purchaseCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByCliente(String clientId) {
        return purchaseCrudRepository.findByIdClient(clientId)
        .map(purchases -> mapper.toPurchases(purchases));
    }

    @Override
    public Purchase save(Purchase purchase) {
        PuchaseEntity compra = mapper.toPuchaseEntity(purchase);
        compra.getProducts().forEach(product -> product.setPuchase(compra));
        return mapper.toPurchase(purchaseCrudRepository.save(compra));
    }


}
