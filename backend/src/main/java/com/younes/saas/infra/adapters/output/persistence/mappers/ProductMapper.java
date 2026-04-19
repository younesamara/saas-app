package com.younes.saas.infra.adapters.output.persistence.mappers;


import com.younes.saas.domain.models.Product;
import com.younes.saas.infra.adapters.output.persistence.models.ProductEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toDomain(ProductEntity entity);

    ProductEntity toJpa(Product model);
}
