package com.younes.saas.application.usecase.category;

import com.younes.saas.application.annotations.Command;
import com.younes.saas.application.ports.in.category.CreateCategoryCommand;
import com.younes.saas.application.ports.in.category.CategoryCommandUseCase;
import com.younes.saas.application.ports.in.category.UpdateCategoryCommand;
import com.younes.saas.application.ports.out.CategoryRepository;
import com.younes.saas.domain.models.Category;

@Command
public class CategoryCommandUseCaseImpl implements CategoryCommandUseCase {

    private final CategoryRepository categoryRepository;

    public CategoryCommandUseCaseImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void create(CreateCategoryCommand command) {

        Category newCategory = new Category(
                command.name(),
                command.description()
        );

        this.categoryRepository.save(newCategory);
    }

    @Override
    public void delete(String id) {
        this.categoryRepository.delete(id);
    }

    @Override
    public void update(String id, UpdateCategoryCommand command) {
        Category category = new Category(
                command.name(),
                command.description()
        );

        this.categoryRepository.update(id, category);
    }
}
