package com.younes.saas.infra.adapters.in.web.category;

import com.younes.saas.domain.common.PageResult;
import com.younes.saas.domain.models.Category;
import com.younes.saas.domain.ports.in.category.ListCategoriesUseCase;
import com.younes.saas.domain.ports.in.category.GetCategoryUseCase;
import com.younes.saas.infra.adapters.in.web.category.dto.CategoryResponse;
import com.younes.saas.infra.adapters.in.web.category.mapper.CategoryWebMapper;
import com.younes.saas.infra.adapters.in.web.common.PageResponse;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryQueryController {

    private final ListCategoriesUseCase categoriesUseCase;
    private final GetCategoryUseCase categoryUseCase;
    private final CategoryWebMapper mapper;

    @GetMapping
    public ResponseEntity<PageResponse<CategoryResponse>> getAllCategories(
            @RequestParam(name = "page", defaultValue = "0") final int page,
            @RequestParam(name = "size", defaultValue = "10") final int size
    ) {
        PageResult<Category> domainCategories = categoriesUseCase.execute(page, size);
        PageResponse<CategoryResponse> response = mapper.toPageResponse(domainCategories);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getCategoryById(
            @PathVariable("id")
            @NotNull(message = "Category ID cannot be null") final String id
    ) {
        Category domainCategory = this.categoryUseCase.execute(id);
        return ResponseEntity.ok(mapper.toResponse(domainCategory));
    }
}
