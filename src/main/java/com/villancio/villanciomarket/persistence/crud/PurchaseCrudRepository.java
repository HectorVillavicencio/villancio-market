package com.villancio.villanciomarket.persistence.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.villancio.villanciomarket.persistence.entity.PuchaseEntity;

public interface PurchaseCrudRepository extends CrudRepository<PuchaseEntity, Integer>{

    Optional<List<PuchaseEntity>> findByIdClient(String idClient);
}
