package com.marco.msproduct.controller;

import com.marco.msproduct.dto.ProductRequest;
import com.marco.msproduct.entity.Product;
import com.marco.msproduct.mapper.ProductMapper;
import com.marco.msproduct.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/products")
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;
    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id){
        return null;
    }

    @PostMapping
    public ResponseEntity<Long> create(@Valid @RequestBody ProductRequest request, UriComponentsBuilder ucb){
        URI location = ucb.cloneBuilder().path("api/v1/products/{id}").buildAndExpand(12).toUri();
        return null;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll(){
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody ProductRequest request){
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        return null;
    }
}
