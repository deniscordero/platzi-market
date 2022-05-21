package com.platzi.platzimarket.persistence.mapper;

import com.platzi.platzimarket.domain.PurchaseItem;
import com.platzi.platzimarket.persistence.entity.PurchaseProduct;
import com.platzi.platzimarket.persistence.entity.PurchaseProductPK;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-17T18:58:48-0600",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.14 (Eclipse Adoptium)"
)
@Component
public class PurchaseItemMapperImpl implements PurchaseItemMapper {

    @Override
    public PurchaseItem toPurchaseItem(PurchaseProduct product) {
        if ( product == null ) {
            return null;
        }

        PurchaseItem purchaseItem = new PurchaseItem();

        Integer idPurchase = productIdIdPurchase( product );
        if ( idPurchase != null ) {
            purchaseItem.setProductId( idPurchase );
        }
        if ( product.getStatus() != null ) {
            purchaseItem.setActive( product.getStatus() );
        }
        if ( product.getQuantity() != null ) {
            purchaseItem.setQuantity( product.getQuantity() );
        }
        if ( product.getTotal() != null ) {
            purchaseItem.setTotal( product.getTotal() );
        }

        return purchaseItem;
    }

    @Override
    public PurchaseProduct toPurchaseProduct(PurchaseItem item) {
        if ( item == null ) {
            return null;
        }

        PurchaseProduct purchaseProduct = new PurchaseProduct();

        purchaseProduct.setStatus( item.isActive() );
        purchaseProduct.setQuantity( item.getQuantity() );
        purchaseProduct.setTotal( item.getTotal() );
        purchaseProduct.setId( purchaseItemToPurchaseProductPK( item ) );

        return purchaseProduct;
    }

    private Integer productIdIdPurchase(PurchaseProduct purchaseProduct) {
        if ( purchaseProduct == null ) {
            return null;
        }
        PurchaseProductPK id = purchaseProduct.getId();
        if ( id == null ) {
            return null;
        }
        Integer idPurchase = id.getIdPurchase();
        if ( idPurchase == null ) {
            return null;
        }
        return idPurchase;
    }

    protected PurchaseProductPK purchaseItemToPurchaseProductPK(PurchaseItem purchaseItem) {
        if ( purchaseItem == null ) {
            return null;
        }

        PurchaseProductPK purchaseProductPK = new PurchaseProductPK();

        return purchaseProductPK;
    }
}
