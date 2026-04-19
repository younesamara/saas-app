package com.younes.saas.domain.ports.input;

import com.younes.saas.domain.models.StockMvt;

import java.util.List;

public interface ManageStockMvtUseCase {
    List<StockMvt> execute();
}

