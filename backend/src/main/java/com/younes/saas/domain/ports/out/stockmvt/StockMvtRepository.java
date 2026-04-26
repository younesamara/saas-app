package com.younes.saas.domain.ports.out.stockmvt;

import com.younes.saas.domain.common.PageResult;
import com.younes.saas.domain.models.StockMvt;

import java.util.Optional;

public interface StockMvtRepository {

    PageResult<StockMvt> findAll(int page, int size);

    Optional<StockMvt> findById(String id);
}
