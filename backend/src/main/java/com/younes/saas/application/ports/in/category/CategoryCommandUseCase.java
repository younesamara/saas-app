package com.younes.saas.application.ports.in.category;

public interface CategoryCommandUseCase {
    void create(CreateCategoryCommand command);
    void delete(String id);
    void update(String id,UpdateCategoryCommand command);
}
