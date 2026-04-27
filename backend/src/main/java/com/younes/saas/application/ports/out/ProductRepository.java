package com.younes.saas.application.ports.out;

import com.younes.saas.application.common.PageResult;
import com.younes.saas.domain.models.Product;

import java.util.Optional;

public interface ProductRepository {
    PageResult<Product> findAll(int page, int size);

    Optional<Product> findById(String id);
}
