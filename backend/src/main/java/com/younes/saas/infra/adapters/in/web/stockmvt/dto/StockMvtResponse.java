package com.younes.saas.infra.adapters.in.web.stockmvt.dto;

import com.younes.saas.domain.models.TypeMvt;

import java.time.LocalDate;

public record StockMvtResponse(
        String id,
        TypeMvt typeMvt,
        Integer quantity,
        LocalDate dateMvt,
        String comment
) {
}


