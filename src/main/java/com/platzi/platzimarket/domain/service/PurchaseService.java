package com.platzi.platzimarket.domain.service;

import com.platzi.platzimarket.domain.PurchaseDTO;
import com.platzi.platzimarket.persistence.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<PurchaseDTO> getAll() {
        return purchaseRepository.getAll();
    }

    public Optional<List<PurchaseDTO>> getByClient(String clientId) {
        return purchaseRepository.getByClient(clientId);
    }

    public PurchaseDTO save(PurchaseDTO purchaseDTO) {
        return purchaseRepository.save(purchaseDTO);
    }


}
