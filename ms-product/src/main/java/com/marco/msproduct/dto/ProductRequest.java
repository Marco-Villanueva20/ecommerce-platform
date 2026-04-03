package com.marco.msproduct.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductRequest(

        @NotNull(message = "Product Name cannot be null")
        String name,
        String description,
        @NotNull(message = "Product Price cannot be null")
        BigDecimal price,
        @NotNull(message = "Product Stock cannot be null")
        Integer stock,
        String imageUrl,
        @NotNull(message = "Product Category cannot be null")
        Long categoryId

) {
}
