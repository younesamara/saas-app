package com.younes.saas.application.services.category;

import com.younes.saas.application.annotations.UseCase;
import com.younes.saas.domain.common.PageResult;
import com.younes.saas.domain.models.Category;
import com.younes.saas.domain.ports.in.category.ListCategoriesUseCase;
import com.younes.saas.domain.ports.out.category.CategoryRepository;

@UseCase
public class ListAllCategoriesService implements ListCategoriesUseCase {

    private final CategoryRepository categoryRepository;

    public ListAllCategoriesService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public PageResult<Category> execute(int page, int size) {
        return categoryRepository.findAll(page, size);
    }
}
