package com.younes.saas.infra.adapters.output.persistence.mappers;

import com.younes.saas.domain.models.Category;
import com.younes.saas.infra.adapters.output.persistence.models.CategoryEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category toDomain(CategoryEntity entity);

    CategoryEntity toJpa(Category domain);

}
