package com.younes.saas.domain.ports.in.stockmvt;

import com.younes.saas.domain.common.PageResult;
import com.younes.saas.domain.models.StockMvt;

public interface ListStockMvtsUseCase {

    PageResult<StockMvt> execute(int page,int size);
}
