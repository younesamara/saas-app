package com.younes.saas.infra.adapters.in.web.stockmvt.mapper;

import com.younes.saas.domain.models.StockMvt;
import com.younes.saas.infra.adapters.in.web.common.BaseWebPageMapper;
import com.younes.saas.infra.adapters.in.web.stockmvt.dto.StockMvtResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StockMvtWebMapper extends BaseWebPageMapper<StockMvt,StockMvtResponse> {

    StockMvtResponse toResponse(StockMvt stockMvt);
}
