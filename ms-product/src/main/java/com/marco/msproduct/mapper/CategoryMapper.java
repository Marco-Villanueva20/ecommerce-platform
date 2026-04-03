package com.marco.msproduct.mapper;

import com.marco.msproduct.dto.CategoryRequest;
import com.marco.msproduct.dto.CategoryResponse;
import com.marco.msproduct.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public CategoryResponse toCategoryResponse(Category category) {
        return new CategoryResponse(
                category.getId(),
                category.getName(),
                category.getDescription(),
                category.getProducts().stream()
                .map(ProductMapper::toProductResponse).toList());
    }

    public Category toCategory(CategoryRequest categoryRequest)
    {
        return new Category(
                categoryRequest.name(),
                categoryRequest.description()
        );

    }

}
