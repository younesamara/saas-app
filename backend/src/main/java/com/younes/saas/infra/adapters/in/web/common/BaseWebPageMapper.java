package com.younes.saas.infra.adapters.in.web.common;

import com.younes.saas.application.common.PageResult;

/**
 * @param <D> The pure Domain model
 * @param <R> The Web Response DTO
 */
public interface BaseWebPageMapper<D, R> {
    PageResponse<R> toPageResponse(PageResult<D> domainPage);
}
