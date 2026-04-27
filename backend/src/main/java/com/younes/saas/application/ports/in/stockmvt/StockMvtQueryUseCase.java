package com.younes.saas.application.ports.in.stockmvt;

import com.younes.saas.application.common.PageResult;
import com.younes.saas.domain.models.StockMvt;

public interface StockMvtQueryUseCase {
    StockMvt getStockMvtById(String id);
    PageResult<StockMvt> listStockMvts(int page, int size);

}
