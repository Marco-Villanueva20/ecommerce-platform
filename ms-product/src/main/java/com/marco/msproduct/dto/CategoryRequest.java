package com.marco.msproduct.dto;

import jakarta.validation.constraints.NotNull;

public record CategoryRequest(
        @NotNull(message = "Category name is required")
        String name,
        String description
) {
}
