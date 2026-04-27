package com.younes.saas.infra.adapters.in.web.category.mapper;

import com.younes.saas.application.ports.in.category.CreateCategoryCommand;
import com.younes.saas.application.ports.in.category.UpdateCategoryCommand;
import com.younes.saas.domain.models.Category;
import com.younes.saas.infra.adapters.in.web.category.dto.CategoryRequest;
import com.younes.saas.infra.adapters.in.web.category.dto.CategoryResponse;
import com.younes.saas.infra.adapters.in.web.common.BaseWebPageMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryWebMapper extends BaseWebPageMapper<Category, CategoryResponse> {

    CategoryResponse toResponse(Category category);

    CreateCategoryCommand toCreateCommand(CategoryRequest request);
    UpdateCategoryCommand toUpdateCommand(CategoryRequest request);
}
