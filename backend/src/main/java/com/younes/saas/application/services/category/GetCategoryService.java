package com.younes.saas.application.services.category;

import com.younes.saas.application.annotations.UseCase;
import com.younes.saas.domain.exceptions.ResourceNotFoundException;
import com.younes.saas.domain.models.Category;
import com.younes.saas.domain.ports.in.category.GetCategoryUseCase;
import com.younes.saas.domain.ports.out.category.CategoryRepository;

@UseCase
public class GetCategoryService implements GetCategoryUseCase {

    private final CategoryRepository categoryRepository;

    public GetCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category execute(String id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category with ID " + id + " not found"));
    }
}
