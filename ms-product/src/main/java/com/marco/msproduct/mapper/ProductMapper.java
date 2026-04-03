package com.marco.msproduct.mapper;

import com.marco.msproduct.dto.ProductResponse;
import com.marco.msproduct.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public static ProductResponse toProductResponse(Product product) {
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
}
