package com.younes.saas.infra.adapters.output.persistence.mappers;

import com.younes.saas.domain.models.StockMvt;
import com.younes.saas.infra.adapters.output.persistence.models.StockMvtEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StockMvtMapper {

    @Mapping(source = "product.id", target = "productId")
    StockMvt toDomain(StockMvtEntity entity);

    @Mapping(source = "productId", target = "product.id")
    StockMvtEntity toJpa(StockMvt model);

}
