package com.younes.saas.application.usecase.category;

import com.younes.saas.application.annotations.Query;
import com.younes.saas.application.common.PageResult;
import com.younes.saas.application.ports.in.category.CategoryQueryUseCase;
import com.younes.saas.domain.exceptions.ResourceNotFoundException;
import com.younes.saas.domain.models.Category;
import com.younes.saas.application.ports.out.CategoryRepository;

@Query
public class CategoryQueryUseCaseImpl implements CategoryQueryUseCase {

    private final CategoryRepository categoryRepository;

    public CategoryQueryUseCaseImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category getCategoryById(String id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category with ID " + id + " not found"));
    }

    @Override
    public PageResult<Category> listCategories(int page, int size) {
        return categoryRepository.findAll(page, size);
    }

}
