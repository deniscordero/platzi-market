package com.platzi.platzimarket.persistence.mapper;

import com.platzi.platzimarket.domain.PurchaseItem;
import com.platzi.platzimarket.persistence.entity.PurchaseProduct;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {

    @Mappings({
            @Mapping(source = "id.idPurchase", target = "productId"),
            @Mapping(source = "status", target = "active")
    })
    PurchaseItem toPurchaseItem(PurchaseProduct product);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "purchase", ignore = true),
            @Mapping(target = "product", ignore = true),
            @Mapping(target = "id.idPurchase", ignore = true)
    })
    PurchaseProduct toPurchaseProduct(PurchaseItem item);

}
