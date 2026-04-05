package com.marco.msproduct.controller;

import com.marco.msproduct.dto.ProductQuantityRequest;
import com.marco.msproduct.dto.ProductRequest;
import com.marco.msproduct.dto.ProductResponse;
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
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/products")
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getById(@PathVariable Long id){
        return ResponseEntity.ok(productMapper.toProductResponse(productService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<Long> create(@Valid @RequestBody ProductRequest request, UriComponentsBuilder ucb){
        Product product = productService.save(productMapper.toProduct(request));
        URI location = ucb.cloneBuilder().path("api/v1/products/{id}").buildAndExpand(product.getId()).toUri();
        return ResponseEntity.created(location).body(product.getId());
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAll(){
        return ResponseEntity.ok(productService.findAll().stream().map(productMapper::toProductResponse).toList());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody ProductRequest request){
        productService.update(productMapper.toProduct(request), id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        productService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @PostMapping("/purchase")
    public ResponseEntity<Void> purchaseProduct(@Valid @RequestBody List<ProductQuantityRequest> requests){
        productService.purchaseProduct(requests);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/restock")
    public ResponseEntity<Void> updateProductStock(@Valid @RequestBody List<ProductQuantityRequest> requests){
        productService.restockProduct(requests);
        return ResponseEntity.ok().build();
    }
}
