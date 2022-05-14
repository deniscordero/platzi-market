package com.platzi.platzimarket.persistence.mapper;

import com.platzi.platzimarket.domain.ProductDTO;
import com.platzi.platzimarket.persistence.entity.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {

    @Mappings({
            @Mapping(source = "idProduct", target = "productId"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "idCategory", target = "categoryId"),
            @Mapping(source = "salesPrice", target = "price"),
            @Mapping(source = "stockQuantity", target = "stock"),
            @Mapping(source = "status", target = "active"),
            @Mapping(source = "category", target = "category"),
    })
    ProductDTO toProductDTO(Product product);

    List<ProductDTO> toProductsDTO(List<Product> products);


    @InheritInverseConfiguration
    @Mapping(target = "barcode", ignore = true)
    Product toProduct(ProductDTO productDTO);
}
