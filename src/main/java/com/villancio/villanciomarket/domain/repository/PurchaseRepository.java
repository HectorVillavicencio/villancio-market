package com.villancio.villanciomarket.domain.repository;

import java.util.List;
import java.util.Optional;

import com.villancio.villanciomarket.domain.model.Purchase;

public interface PurchaseRepository {
    List<Purchase> getAll();
    Optional<List<Purchase>> getByCliente(String clientId);
    Purchase save(Purchase purchase);


}
