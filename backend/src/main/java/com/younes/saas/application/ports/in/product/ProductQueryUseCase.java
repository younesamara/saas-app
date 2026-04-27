package com.younes.saas.application.ports.in.product;

import com.younes.saas.application.common.PageResult;
import com.younes.saas.domain.models.Product;

public interface ProductQueryUseCase {
    PageResult<Product> listProducts(int page, int size);
    Product getProductById(String id);
}
