package com.younes.saas.infra.adapters.input.web.controllers;

import com.younes.saas.domain.models.StockMvt;
import com.younes.saas.domain.ports.input.ManageStockMvtUseCase;
import com.younes.saas.infra.adapters.input.web.dtos.StockMvtResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stock-mouvements")
public class StockMvtController {

    private final ManageStockMvtUseCase stockMvtUseCase;

    public StockMvtController(ManageStockMvtUseCase stockMvtUseCase) {
        this.stockMvtUseCase = stockMvtUseCase;
    }

    @GetMapping
    public ResponseEntity<List<StockMvtResponse>> getAllStockMovements() {

        List<StockMvt> domainMovements = stockMvtUseCase.execute();

        List<StockMvtResponse> responseBody = domainMovements.stream()
                .map(this::mapToResponse)
                .toList();

        return ResponseEntity.ok(responseBody);
    }

    private StockMvtResponse mapToResponse(StockMvt domain) {
        return StockMvtResponse.builder()
                .id(domain.getId())
                .typeMvt(domain.getTypeMvt())
                .quantity(domain.getQuantity())
                .dateMvt(domain.getDateMvt())
                .comment(domain.getComment())
                .build();
    }

}
