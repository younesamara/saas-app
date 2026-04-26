package com.younes.saas.infra.adapters.in.web.product.mapper;

import com.younes.saas.domain.models.Product;
import com.younes.saas.infra.adapters.in.web.common.BaseWebPageMapper;
import com.younes.saas.infra.adapters.in.web.product.dto.ProductResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper extends BaseWebPageMapper<Product, ProductResponse> {
    ProductResponse toResponse(Product product);
}

