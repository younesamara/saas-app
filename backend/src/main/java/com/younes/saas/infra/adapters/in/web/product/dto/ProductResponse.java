package com.younes.saas.infra.adapters.in.web.product.dto;

import java.math.BigDecimal;

public record ProductResponse(
        String id,
        String name,
        String reference,
        String description,
        Integer alertThreshold,
        BigDecimal price,
        String categoryId,
        String categoryName,
        int availableQuantity
) {
}
