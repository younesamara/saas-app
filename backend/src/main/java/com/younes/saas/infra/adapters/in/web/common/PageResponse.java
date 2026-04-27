package com.younes.saas.infra.adapters.in.web.common;

import com.younes.saas.application.common.PageResult;

import java.util.List;

public record PageResponse<T>(
        List<T> content,
        int page,
        int size,
        long totalElements,
        int totalPages,
        boolean hasNext,
        boolean hasPrevious,
        boolean isFirst,
        boolean isLast
) {
    public static <T> PageResponse<T> of(PageResult<T> pageResult) {
        return new PageResponse<>(
                pageResult.content(),
                pageResult.page(),
                pageResult.size(),
                pageResult.totalElements(),
                pageResult.totalPages(),
                pageResult.hasNext(),
                pageResult.hasPrevious(),
                pageResult.isFirst(),
                pageResult.isLast()
        );
    }
}