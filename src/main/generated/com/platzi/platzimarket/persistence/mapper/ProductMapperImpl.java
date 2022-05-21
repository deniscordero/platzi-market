package com.platzi.platzimarket.persistence.mapper;

import com.platzi.platzimarket.domain.ProductDTO;
import com.platzi.platzimarket.persistence.entity.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-17T18:58:48-0600",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.14 (Eclipse Adoptium)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public ProductDTO toProductDTO(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();

        if ( product.getIdProduct() != null ) {
            productDTO.setProductId( product.getIdProduct() );
        }
        productDTO.setName( product.getName() );
        if ( product.getIdCategory() != null ) {
            productDTO.setCategoryId( product.getIdCategory() );
        }
        if ( product.getSalesPrice() != null ) {
            productDTO.setPrice( product.getSalesPrice() );
        }
        if ( product.getStockQuantity() != null ) {
            productDTO.setStock( product.getStockQuantity() );
        }
        if ( product.getStatus() != null ) {
            productDTO.setActive( product.getStatus() );
        }
        productDTO.setCategory( categoryMapper.toCategoryDTO( product.getCategory() ) );

        return productDTO;
    }

    @Override
    public List<ProductDTO> toProductsDTO(List<Product> products) {
        if ( products == null ) {
            return null;
        }

        List<ProductDTO> list = new ArrayList<ProductDTO>( products.size() );
        for ( Product product : products ) {
            list.add( toProductDTO( product ) );
        }

        return list;
    }

    @Override
    public Product toProduct(ProductDTO productDTO) {
        if ( productDTO == null ) {
            return null;
        }

        Product product = new Product();

        product.setIdProduct( productDTO.getProductId() );
        product.setName( productDTO.getName() );
        product.setIdCategory( productDTO.getCategoryId() );
        product.setSalesPrice( productDTO.getPrice() );
        product.setStockQuantity( productDTO.getStock() );
        product.setStatus( productDTO.isActive() );
        product.setCategory( categoryMapper.toCategory( productDTO.getCategory() ) );

        return product;
    }
}
