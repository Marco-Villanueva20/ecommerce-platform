package com.marco.msproduct.dto;

import jakarta.validation.constraints.NotNull;

public record ProductQuantityRequest(
        @NotNull(message = "Product id cannot be null")
        Long productId,
        @NotNull(message = "Quantity cannot be null")
        Integer quantity
) {
}
