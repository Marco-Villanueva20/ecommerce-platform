package com.marco.msproduct.dto;

import java.util.List;

public record CategoryResponse(
         Long id,
         String name,
         String description,
         List<ProductResponse> products
) {
}
