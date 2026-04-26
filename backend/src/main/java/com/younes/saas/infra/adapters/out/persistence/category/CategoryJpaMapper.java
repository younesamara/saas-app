package com.younes.saas.infra.adapters.out.persistence.category;

import com.younes.saas.domain.models.Category;
import com.younes.saas.infra.adapters.out.persistence.common.BasePageMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryJpaMapper extends BasePageMapper<JpaCategory, Category> {

    Category toDomain(JpaCategory entity);

    JpaCategory toJpa(Category domain);

}
