package com.younes.saas.domain.ports.output;

import com.younes.saas.domain.models.StockMvt;

import java.util.List;

public interface StockMvtRepository {
    List<StockMvt> findAll();
}
