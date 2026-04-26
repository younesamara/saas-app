package com.younes.saas.domain.ports.out.category;

import com.younes.saas.domain.common.PageResult;
import com.younes.saas.domain.models.Category;

import java.util.Optional;


public interface CategoryRepository {
    PageResult<Category> findAll(int page, int size);
    Optional<Category> findById(String id);
}
