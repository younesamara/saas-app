package com.younes.saas.application.usecase.stockmvt;

import com.younes.saas.application.annotations.Query;
import com.younes.saas.application.common.PageResult;
import com.younes.saas.application.ports.in.stockmvt.StockMvtQueryUseCase;
import com.younes.saas.application.ports.out.StockMvtRepository;
import com.younes.saas.domain.exceptions.ResourceNotFoundException;
import com.younes.saas.domain.models.StockMvt;

@Query
public class ListStockMvtsUseCaseImpl implements StockMvtQueryUseCase {

    private final StockMvtRepository stockMvtRepository;

    public ListStockMvtsUseCaseImpl(StockMvtRepository repository) {
        this.stockMvtRepository = repository;
    }

    @Override
    public StockMvt getStockMvtById(String id) {
        return this.stockMvtRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Stock movement with ID " + id + " not found"));
    }

    @Override
    public PageResult<StockMvt> listStockMvts(int page, int size) {
        return stockMvtRepository.findAll(page, size);
    }
}
