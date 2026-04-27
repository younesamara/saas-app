package com.younes.saas.application.ports.in.category;

import com.younes.saas.application.common.PageResult;
import com.younes.saas.domain.models.Category;

public interface CategoryQueryUseCase {

    PageResult<Category> listCategories(int page, int size);

    Category getCategoryById(String id);
}
