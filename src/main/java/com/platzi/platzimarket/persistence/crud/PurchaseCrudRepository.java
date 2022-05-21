package com.platzi.platzimarket.persistence.crud;

import com.platzi.platzimarket.domain.PurchaseDTO;
import com.platzi.platzimarket.persistence.entity.Purchase;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PurchaseCrudRepository extends CrudRepository<Purchase, Integer> {

    Optional<List<Purchase>> findByIdClient(String idClient);
}
