package com.platzi.platzimarket.persistence.mapper;

import com.platzi.platzimarket.domain.PurchaseDTO;
import com.platzi.platzimarket.persistence.entity.Purchase;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "srping", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {

    @Mappings({
            @Mapping(source = "idShopping", target = "purchaseId"),
            @Mapping(source = "idClient", target = "clientId"),
            @Mapping(source = "date", target = "date"),
            @Mapping(source = "paymentMethod", target = "paymentMethod"),
            @Mapping(source = "comment", target = "comment"),
            @Mapping(source = "status", target = "state"),
            @Mapping(source = "products", target = "items")
    })
    PurchaseDTO toPurchaseDto(Purchase purchase);
    List<PurchaseDTO> toPurchases(List<Purchase> purchases);

    @InheritInverseConfiguration
    @Mapping(target = "idClient", ignore = true)
    Purchase toPurchase(PurchaseDTO purchaseDTO);


}
