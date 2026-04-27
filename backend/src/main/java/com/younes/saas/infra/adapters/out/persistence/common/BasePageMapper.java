package com.younes.saas.infra.adapters.out.persistence.common;

import com.younes.saas.application.common.PageResult;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

/**
 *
 * @param <E> jpa entity
 * @param <D> domain model
 */
public interface BasePageMapper<E, D> {

    @Mapping(source = "number", target = "page")
    PageResult<D> toPageResult(Page<E> page);
}
