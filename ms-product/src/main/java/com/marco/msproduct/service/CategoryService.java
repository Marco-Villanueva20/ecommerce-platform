package com.marco.msproduct.service;

import com.marco.msproduct.dto.CategoryRequest;
import com.marco.msproduct.dto.CategoryResponse;
import com.marco.msproduct.mapper.CategoryMapper;
import com.marco.msproduct.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public List<CategoryResponse> getAllCategories() {
        return null;
    }

    public CategoryResponse create(CategoryRequest request) {
        return null;
    }
}
