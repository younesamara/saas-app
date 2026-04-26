package com.younes.saas.domain.ports.in.category;

import com.younes.saas.domain.models.Category;

public interface GetCategoryUseCase {
    Category execute(String id);
}
