package com.younes.saas.infra.adapters.out.persistence.product;


import com.younes.saas.domain.models.Product;
import com.younes.saas.infra.adapters.out.persistence.common.BasePageMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductJpaMapper extends BasePageMapper<JpaProduct, Product> {

    Product toDomain(JpaProduct entity);

    JpaProduct toJpa(Product model);
}
