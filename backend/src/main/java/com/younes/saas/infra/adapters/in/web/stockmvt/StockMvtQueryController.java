package com.younes.saas.infra.adapters.in.web.stockmvt;

import com.younes.saas.domain.common.PageResult;
import com.younes.saas.domain.models.StockMvt;
import com.younes.saas.domain.ports.in.stockmvt.GetStockMvtUseCase;
import com.younes.saas.domain.ports.in.stockmvt.ListStockMvtsUseCase;
import com.younes.saas.infra.adapters.in.web.common.PageResponse;
import com.younes.saas.infra.adapters.in.web.stockmvt.dto.StockMvtResponse;
import com.younes.saas.infra.adapters.in.web.stockmvt.mapper.StockMvtWebMapper;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stock-mouvements")
@RequiredArgsConstructor
public class StockMvtQueryController {

    private final ListStockMvtsUseCase stockMvtsUseCase;
    private final GetStockMvtUseCase stockMvtUseCase;
    private final StockMvtWebMapper mapper;

    @GetMapping
    public ResponseEntity<PageResponse<StockMvtResponse>> getAllStockMovements(
            @RequestParam(name = "page", defaultValue = "0") final int page,
            @RequestParam(name = "size", defaultValue = "10") final int size
    ) {

        PageResult<StockMvt> domainMovements = stockMvtsUseCase.execute(page, size);
        PageResponse<StockMvtResponse> response = mapper.toPageResponse(domainMovements);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockMvtResponse> getStockMvtById(
            @PathVariable("id")
            @NotNull(message = "Stock movement ID cannot be null")
            String id) {

        StockMvt stockMvt = this.stockMvtUseCase.execute(id);
        return ResponseEntity.ok(mapper.toResponse(stockMvt));
    }

}
