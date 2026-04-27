package com.younes.saas.application.ports.out;

import com.younes.saas.application.common.PageResult;
import com.younes.saas.domain.models.Category;

import java.util.Optional;


public interface CategoryRepository {
    PageResult<Category> findAll(int page, int size);

    Optional<Category> findById(String id);

    void save(Category category);

    void delete(String id);

    void update(String id, Category category);
}
