package com.marco.msproduct.mapper;

import com.marco.msproduct.dto.CategoryRequest;
import com.marco.msproduct.dto.CategoryResponse;
import com.marco.msproduct.entity.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryMapper {
    private final ProductMapper productMapper;
    public CategoryResponse toCategoryResponse(Category category) {
        return new CategoryResponse(
                category.getId(),
                category.getName(),
                category.getDescription(),
                category.getProducts().stream()
                .map(productMapper::toProductResponse).toList());
    }

    public Category toCategory(CategoryRequest categoryRequest)
    {
        return new Category(
                categoryRequest.name(),
                categoryRequest.description()
        );

    }

}
