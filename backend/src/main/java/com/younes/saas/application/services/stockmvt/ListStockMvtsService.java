package com.younes.saas.application.services.stockmvt;

import com.younes.saas.application.annotations.Query;
import com.younes.saas.domain.common.PageResult;
import com.younes.saas.domain.models.StockMvt;
import com.younes.saas.domain.ports.in.stockmvt.ListStockMvtsUseCase;
import com.younes.saas.domain.ports.out.stockmvt.StockMvtRepository;

@Query
public class ListStockMvtsService implements ListStockMvtsUseCase {

    private final StockMvtRepository stockMvtRepository;

    public ListStockMvtsService(StockMvtRepository repository) {
        this.stockMvtRepository = repository;
    }

    @Override
    public PageResult<StockMvt> execute(int page, int size) {
        return stockMvtRepository.findAll(page, size);
    }
}
