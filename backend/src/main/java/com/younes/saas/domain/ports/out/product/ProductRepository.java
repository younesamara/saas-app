package com.younes.saas.domain.ports.out.product;

import com.younes.saas.domain.common.PageResult;
import com.younes.saas.domain.models.Product;

import java.util.Optional;

public interface ProductRepository {
    PageResult<Product> findAll(int page, int size);

    Optional<Product> findById(String id);
}
