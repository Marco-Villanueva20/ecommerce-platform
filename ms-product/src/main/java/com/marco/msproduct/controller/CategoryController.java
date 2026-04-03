package com.marco.msproduct.controller;

import com.marco.msproduct.dto.CategoryRequest;
import com.marco.msproduct.dto.CategoryResponse;
import com.marco.msproduct.entity.Category;
import com.marco.msproduct.mapper.CategoryMapper;
import com.marco.msproduct.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryMapper categoryMapper;
    private final CategoryService categoryService;

    // CREATE
    @PostMapping
    public ResponseEntity<Long> createCategory(
            @Valid @RequestBody CategoryRequest request,
            UriComponentsBuilder ucb) {

        Long id = categoryService.create(categoryMapper.toCategory(request));
        URI location = ucb.cloneBuilder().path("api/v1/categories/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(location).body(id);

    }

    // READ
    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getAllCategories() {
        List<CategoryResponse> categories = categoryService.getAllCategories()
                .stream()
                .map(categoryMapper::toCategoryResponse)
                .toList();
        return ResponseEntity.ok(categories);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getById(@PathVariable Long id){
        return ResponseEntity.ok(categoryMapper.toCategoryResponse(categoryService.findById(id)));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCategory(@PathVariable Long id, @Valid @RequestBody CategoryRequest categoryRequest) {

        Category category =categoryMapper.toCategory(categoryRequest);
        categoryService.update(id, category);
        return ResponseEntity.noContent().build();
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id){
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
