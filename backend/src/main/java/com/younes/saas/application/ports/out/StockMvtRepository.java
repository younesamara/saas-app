package com.younes.saas.application.ports.out;

import com.younes.saas.application.common.PageResult;
import com.younes.saas.domain.models.StockMvt;

import java.util.Optional;

public interface StockMvtRepository {

    PageResult<StockMvt> findAll(int page, int size);

    Optional<StockMvt> findById(String id);
}
