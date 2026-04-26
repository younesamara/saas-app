package com.younes.saas.domain.ports.in.stockmvt;

import com.younes.saas.domain.models.StockMvt;

public interface GetStockMvtUseCase {

    StockMvt execute(String id);
}
