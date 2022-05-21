package com.platzi.platzimarket.web.controller;

import com.platzi.platzimarket.domain.PurchaseDTO;
import com.platzi.platzimarket.domain.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping()
    public ResponseEntity<List<PurchaseDTO>> getAll() {
        return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<List<PurchaseDTO>> getByClient(@PathVariable("id") String clientId) {
        return purchaseService.getByClient(clientId).map(
                purchaseDTOS -> new ResponseEntity<>(purchaseDTOS, HttpStatus.OK)
        ).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
//        if (purchaseService.getByClient(clientId).get().isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        } else {
//            return new ResponseEntity(purchaseService.getByClient(clientId), HttpStatus.OK);
//        }
    }

    @PostMapping()
    public ResponseEntity<PurchaseDTO> save(@RequestBody PurchaseDTO purchaseDTO) {
        return new ResponseEntity<>(purchaseService.save(purchaseDTO), HttpStatus.CREATED);
    }





}
