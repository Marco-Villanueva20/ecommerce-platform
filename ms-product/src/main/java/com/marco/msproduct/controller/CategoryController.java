package com.marco.msproduct.controller;

import com.marco.msproduct.dto.CategoryRequest;
import com.marco.msproduct.dto.CategoryResponse;
import com.marco.msproduct.service.CategoryService;
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

    private final CategoryService categoryService;
    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getAllCategories(){

        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> createCategory(@RequestBody CategoryRequest request, UriComponentsBuilder ucb){
        CategoryResponse response = categoryService.create(request);
        URI location = ucb.cloneBuilder().path("api/v1/categories/{id}").buildAndExpand(response.id).toUri();
        return ResponseEntity.created(location).body(response);
    }
}
