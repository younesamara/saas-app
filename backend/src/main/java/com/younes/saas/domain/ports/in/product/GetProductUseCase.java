package com.younes.saas.domain.ports.in.product;

import com.younes.saas.domain.models.Product;

public interface GetProductUseCase {
    Product execute(String id);
}
