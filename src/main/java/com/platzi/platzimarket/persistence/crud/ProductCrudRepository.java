package com.platzi.platzimarket.persistence.crud;

import com.platzi.platzimarket.persistence.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository  extends CrudRepository<Product, Integer> {

    List<Product> findByIdCategory(int idCategory);
    List<Product> findByIdCategoryOrderByNameAsc(int idCategory);
    Optional<List<Product>> findByStockQuantityLessThanAndStatus(int stockQuantity, boolean status);
}
