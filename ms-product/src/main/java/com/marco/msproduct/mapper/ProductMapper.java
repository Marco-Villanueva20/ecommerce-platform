package com.marco.msproduct.mapper;

import com.marco.msproduct.dto.ProductRequest;
import com.marco.msproduct.dto.ProductResponse;
import com.marco.msproduct.entity.Category;
import com.marco.msproduct.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductResponse toProductResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getStock(),
                product.getImageUrl(),
                product.getCategory().getId(),
                product.getCategory().getName(),
                product.getCategory().getDescription()
        );
    }

    public Product toProduct(ProductRequest request){
        return new Product(
                request.name(),
                request.description(),
                request.price(),
                request.stock(),
                request.imageUrl(),
                new Category(request.categoryId())
        );
    }
}
