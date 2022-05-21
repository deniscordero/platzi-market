package com.platzi.platzimarket.persistence.mapper;

import com.platzi.platzimarket.domain.PurchaseDTO;
import com.platzi.platzimarket.domain.PurchaseItem;
import com.platzi.platzimarket.persistence.entity.Purchase;
import com.platzi.platzimarket.persistence.entity.PurchaseProduct;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-17T19:40:08-0600",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.14 (Eclipse Adoptium)"
)
@Component
public class PurchaseMapperImpl implements PurchaseMapper {

    @Autowired
    private PurchaseItemMapper purchaseItemMapper;

    @Override
    public PurchaseDTO toPurchaseDTO(Purchase purchase) {
        if ( purchase == null ) {
            return null;
        }

        PurchaseDTO purchaseDTO = new PurchaseDTO();

        if ( purchase.getIdPurchase() != null ) {
            purchaseDTO.setPurchaseId( purchase.getIdPurchase() );
        }
        purchaseDTO.setClientId( purchase.getIdClient() );
        if ( purchase.getStatus() != null ) {
            purchaseDTO.setState( purchase.getStatus().toString() );
        }
        purchaseDTO.setItems( purchaseProductListToPurchaseItemList( purchase.getProducts() ) );
        purchaseDTO.setDate( purchase.getDate() );
        if ( purchase.getPaymentMethod() != null ) {
            purchaseDTO.setPaymentMethod( purchase.getPaymentMethod().toString() );
        }
        purchaseDTO.setComment( purchase.getComment() );

        return purchaseDTO;
    }

    @Override
    public List<PurchaseDTO> toPurchasesDTO(List<Purchase> purchases) {
        if ( purchases == null ) {
            return null;
        }

        List<PurchaseDTO> list = new ArrayList<PurchaseDTO>( purchases.size() );
        for ( Purchase purchase : purchases ) {
            list.add( toPurchaseDTO( purchase ) );
        }

        return list;
    }

    @Override
    public Purchase toPurchase(PurchaseDTO purchaseDTO) {
        if ( purchaseDTO == null ) {
            return null;
        }

        Purchase purchase = new Purchase();

        purchase.setIdPurchase( purchaseDTO.getPurchaseId() );
        purchase.setIdClient( purchaseDTO.getClientId() );
        if ( purchaseDTO.getState() != null ) {
            purchase.setStatus( purchaseDTO.getState().charAt( 0 ) );
        }
        purchase.setProducts( purchaseItemListToPurchaseProductList( purchaseDTO.getItems() ) );
        purchase.setDate( purchaseDTO.getDate() );
        if ( purchaseDTO.getPaymentMethod() != null ) {
            purchase.setPaymentMethod( purchaseDTO.getPaymentMethod().charAt( 0 ) );
        }
        purchase.setComment( purchaseDTO.getComment() );

        return purchase;
    }

    protected List<PurchaseItem> purchaseProductListToPurchaseItemList(List<PurchaseProduct> list) {
        if ( list == null ) {
            return null;
        }

        List<PurchaseItem> list1 = new ArrayList<PurchaseItem>( list.size() );
        for ( PurchaseProduct purchaseProduct : list ) {
            list1.add( purchaseItemMapper.toPurchaseItem( purchaseProduct ) );
        }

        return list1;
    }

    protected List<PurchaseProduct> purchaseItemListToPurchaseProductList(List<PurchaseItem> list) {
        if ( list == null ) {
            return null;
        }

        List<PurchaseProduct> list1 = new ArrayList<PurchaseProduct>( list.size() );
        for ( PurchaseItem purchaseItem : list ) {
            list1.add( purchaseItemMapper.toPurchaseProduct( purchaseItem ) );
        }

        return list1;
    }
}
