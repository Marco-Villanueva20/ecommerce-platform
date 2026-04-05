package com.marco.msproduct.service;

import com.marco.msproduct.entity.Product;
import com.marco.msproduct.exception.ProductException;
import com.marco.msproduct.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product save(Product product){
        return productRepository.save(product);
    }

    public Product findById(Long id){
        return productRepository.findById(id).orElseThrow(()-> new ProductException("Product not found"));
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public void deleteById(Long id){
        productRepository.deleteById(id);
    }

    public void update(Product product, Long id){
        Product entity = findById(id);
        entity.update(product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getStock(),
                product.getImageUrl());
        productRepository.save(entity);
    }


}
