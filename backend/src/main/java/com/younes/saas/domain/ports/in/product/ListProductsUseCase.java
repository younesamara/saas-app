package com.younes.saas.domain.ports.in.product;

import com.younes.saas.domain.common.PageResult;
import com.younes.saas.domain.models.Product;

public interface ListProductsUseCase {
    PageResult<Product> execute(int page, int size);
}
