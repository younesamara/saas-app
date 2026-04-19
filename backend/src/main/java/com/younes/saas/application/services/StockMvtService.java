package com.younes.saas.application.services;

import com.younes.saas.application.annotations.UseCase;
import com.younes.saas.domain.models.StockMvt;
import com.younes.saas.domain.ports.input.ManageStockMvtUseCase;
import com.younes.saas.domain.ports.output.StockMvtRepository;

import java.util.List;

@UseCase
public class StockMvtService implements ManageStockMvtUseCase {

    private final StockMvtRepository stockMvtRepository;

    public StockMvtService(StockMvtRepository stockMvtRepository) {
        this.stockMvtRepository = stockMvtRepository;
    }

    @Override
    public List<StockMvt> execute() {
        return this.stockMvtRepository.findAll();
    }
}
