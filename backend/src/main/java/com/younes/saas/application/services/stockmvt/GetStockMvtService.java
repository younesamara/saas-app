package com.younes.saas.application.services.stockmvt;

import com.younes.saas.application.annotations.Query;
import com.younes.saas.domain.exceptions.ResourceNotFoundException;
import com.younes.saas.domain.models.StockMvt;
import com.younes.saas.domain.ports.in.stockmvt.GetStockMvtUseCase;
import com.younes.saas.domain.ports.out.stockmvt.StockMvtRepository;

@Query
public class GetStockMvtService implements GetStockMvtUseCase {

    private final StockMvtRepository stockMvtRepository;

    public GetStockMvtService(StockMvtRepository stockMvtRepository) {
        this.stockMvtRepository = stockMvtRepository;
    }

    @Override
    public StockMvt execute(String id) {
        return this.stockMvtRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Stock movement with ID " + id + " not found"));
    }
}
