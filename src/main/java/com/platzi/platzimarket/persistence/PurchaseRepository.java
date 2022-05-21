package com.platzi.platzimarket.persistence;

import com.platzi.platzimarket.domain.PurchaseDTO;
import com.platzi.platzimarket.persistence.crud.PurchaseCrudRepository;
import com.platzi.platzimarket.persistence.entity.Purchase;
import com.platzi.platzimarket.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PurchaseRepository implements com.platzi.platzimarket.domain.repository.PurchaseRepository {

    @Autowired
    private PurchaseCrudRepository purchaseCrudRepository;

    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<PurchaseDTO> getAll() {
        return mapper.toPurchasesDTO((List<Purchase>) purchaseCrudRepository.findAll());
    }

    @Override
    public Optional<List<PurchaseDTO>> getByClient(String clientId) {
        return purchaseCrudRepository.findByIdClient(clientId)
                .map(purchases -> mapper.toPurchasesDTO(purchases));
    }

    @Override
    public PurchaseDTO save(PurchaseDTO purchaseDTO) {
        Purchase purchase = mapper.toPurchase(purchaseDTO);
        purchase.getProducts().forEach(product -> product.setPurchase(purchase));
        return mapper.toPurchaseDTO(purchaseCrudRepository.save(purchase));
    }
}
