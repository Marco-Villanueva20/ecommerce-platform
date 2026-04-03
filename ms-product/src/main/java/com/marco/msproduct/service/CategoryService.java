package com.marco.msproduct.service;

import com.marco.msproduct.dto.CategoryRequest;
import com.marco.msproduct.entity.Category;
import com.marco.msproduct.exception.CategoryException;
import com.marco.msproduct.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    //CREATE
    public Long create(Category request) {
        return categoryRepository.save(request).getId();
    }

    //READ
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id){
        return categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryException("Category with ID %s not found".formatted(id)));
    }

    //UPDATE
    public Category update(Long id, Category newData){
        Category category = findById(id);
        category.update(newData.getName(), newData.getDescription());
        return categoryRepository.save(category);
    }


    //DELETE
    public void delete(Long id){
        categoryRepository.deleteById(id);
    }





}
