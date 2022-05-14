package com.platzi.platzimarket.persistence;

import com.platzi.platzimarket.domain.ProductDTO;
import com.platzi.platzimarket.persistence.crud.ProductCrudRepository;
import com.platzi.platzimarket.persistence.entity.Product;
import com.platzi.platzimarket.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository implements com.platzi.platzimarket.domain.repository.ProductRepository {
    @Autowired
    private ProductCrudRepository productCrudRepository;

    @Autowired
    private ProductMapper mapper;

    @Override
    public List<ProductDTO> getAll() {
        List<Product> products = (List<Product>) productCrudRepository.findAll();
        return mapper.toProductsDTO(products);
    }

    @Override
    public Optional<List<ProductDTO>> getByCategory(int categoryId) {
        List<Product> products = productCrudRepository.findByIdCategoryOrderByNameAsc(categoryId);
        return Optional.of(mapper.toProductsDTO(products));
    }

    @Override
    public Optional<List<ProductDTO>> getScarceProducts(int quantity) {
        Optional<List<Product>> products = productCrudRepository.findByStockQuantityLessThanAndStatus(quantity, true);
        return products.map(prods -> mapper.toProductsDTO(prods));
    }

    @Override
    public Optional<ProductDTO> getProduct(int productId) {
        return productCrudRepository.findById(productId).map(product -> mapper.toProductDTO(product));
    }

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        Product product = mapper.toProduct(productDTO);
        return mapper.toProductDTO(productCrudRepository.save(product));
    }

    @Override
    public void delete(int productId) {
        productCrudRepository.deleteById(productId);
    }
}
