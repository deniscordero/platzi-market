package com.platzi.platzimarket.persistence.mapper;

import com.platzi.platzimarket.domain.CategoryDTO;
import com.platzi.platzimarket.persistence.entity.Category;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-17T18:58:48-0600",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.14 (Eclipse Adoptium)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryDTO toCategoryDTO(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDTO categoryDTO = new CategoryDTO();

        if ( category.getIdCategory() != null ) {
            categoryDTO.setCategoryId( category.getIdCategory() );
        }
        categoryDTO.setCategory( category.getDescription() );
        if ( category.getStatus() != null ) {
            categoryDTO.setActive( category.getStatus() );
        }

        return categoryDTO;
    }

    @Override
    public Category toCategory(CategoryDTO categoryDTO) {
        if ( categoryDTO == null ) {
            return null;
        }

        Category category = new Category();

        category.setIdCategory( categoryDTO.getCategoryId() );
        category.setDescription( categoryDTO.getCategory() );
        category.setStatus( categoryDTO.isActive() );

        return category;
    }
}
