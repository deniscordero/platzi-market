package com.platzi.platzimarket.persistence.mapper;

import com.platzi.platzimarket.domain.CategoryDTO;
import com.platzi.platzimarket.persistence.entity.Category;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mappings({
            @Mapping(source = "idCategory", target = "categoryId"),
            @Mapping(source = "description", target = "category"),
            @Mapping(source = "status", target = "active"),
    })
    CategoryDTO toCategoryDTO(Category category);

    @InheritInverseConfiguration
    @Mapping(target = "products", ignore = true)
    Category toCategory(CategoryDTO categoryDTO);
}
