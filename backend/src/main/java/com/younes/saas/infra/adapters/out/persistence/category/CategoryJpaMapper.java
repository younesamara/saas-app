package com.younes.saas.infra.adapters.out.persistence.category;

import com.younes.saas.domain.models.Category;
import com.younes.saas.infra.adapters.out.persistence.common.BasePageMapper;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CategoryJpaMapper extends BasePageMapper<JpaCategory, Category> {

    Category toDomain(JpaCategory entity);

    JpaCategory toJpaEntity(Category domain);

    @AfterMapping
    default void handleMissingFields(@MappingTarget JpaCategory entity) {
        if (entity.getDeleted() == null)
            entity.setDeleted(false);
    }
}
