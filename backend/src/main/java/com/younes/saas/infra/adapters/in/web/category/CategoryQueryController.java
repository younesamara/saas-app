package com.younes.saas.infra.adapters.in.web.category;

import com.younes.saas.application.common.PageResult;
import com.younes.saas.application.ports.in.category.CategoryQueryUseCase;
import com.younes.saas.domain.models.Category;
import com.younes.saas.infra.adapters.in.web.category.dto.CategoryResponse;
import com.younes.saas.infra.adapters.in.web.category.mapper.CategoryWebMapper;
import com.younes.saas.infra.adapters.in.web.common.PageResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
@Tag(name = "Category", description = "Category API")
public class CategoryQueryController {

    private final CategoryQueryUseCase queryUseCase;
    private final CategoryWebMapper mapper;

    @GetMapping
    public ResponseEntity<PageResponse<CategoryResponse>> getAllCategories(
            @RequestParam(name = "page", defaultValue = "0") final int page,
            @RequestParam(name = "size", defaultValue = "10") final int size
    ) {
        PageResult<Category> domainCategories = this.queryUseCase.listCategories(page, size);
        PageResponse<CategoryResponse> response = mapper.toPageResponse(domainCategories);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getCategoryById(
            @PathVariable("id")
            @NotNull(message = "Category ID cannot be null") final String id
    ) {
        Category domainCategory = this.queryUseCase.getCategoryById(id);
        return ResponseEntity.ok(mapper.toResponse(domainCategory));
    }
}
