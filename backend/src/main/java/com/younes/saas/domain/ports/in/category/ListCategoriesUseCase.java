package com.younes.saas.domain.ports.in.category;

import com.younes.saas.domain.common.PageResult;
import com.younes.saas.domain.models.Category;


public interface ListCategoriesUseCase {
    PageResult<Category> execute(int page, int size);
}
