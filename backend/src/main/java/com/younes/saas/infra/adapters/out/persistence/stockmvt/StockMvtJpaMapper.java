package com.younes.saas.infra.adapters.out.persistence.stockmvt;

import com.younes.saas.domain.models.StockMvt;
import com.younes.saas.infra.adapters.out.persistence.common.BasePageMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StockMvtJpaMapper extends BasePageMapper<JpaStockMvt,StockMvt> {

    @Mapping(source = "product.id", target = "productId")
    StockMvt toDomain(JpaStockMvt entity);

    @Mapping(source = "productId", target = "product.id")
    JpaStockMvt toJpaEntity(StockMvt model);

}
