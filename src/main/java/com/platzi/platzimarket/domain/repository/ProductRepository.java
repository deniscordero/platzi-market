package com.platzi.platzimarket.domain.repository;

import com.platzi.platzimarket.domain.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    List<ProductDTO> getAll();
    Optional<List<ProductDTO>> getByCategory(int categoryId);
    Optional<List<ProductDTO>> getScarceProducts(int quantity);
    Optional<ProductDTO> getProduct(int productId);
    ProductDTO save(ProductDTO product);
    void delete(int productId);

}
