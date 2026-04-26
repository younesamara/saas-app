package com.younes.saas.infra.adapters.in.web.category.mapper;

import com.younes.saas.domain.models.Category;
import com.younes.saas.infra.adapters.in.web.category.dto.CategoryResponse;
import com.younes.saas.infra.adapters.in.web.common.BaseWebPageMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryWebMapper extends BaseWebPageMapper<Category, CategoryResponse> {
    CategoryResponse toResponse(Category category);
}
