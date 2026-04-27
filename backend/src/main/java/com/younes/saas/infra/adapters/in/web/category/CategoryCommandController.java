package com.younes.saas.infra.adapters.in.web.category;

import com.younes.saas.application.ports.in.category.CategoryCommandUseCase;
import com.younes.saas.infra.adapters.in.web.category.dto.CategoryRequest;
import com.younes.saas.infra.adapters.in.web.category.mapper.CategoryWebMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
@Tag(name = "Category", description = "Category API")
public class CategoryCommandController {

    private final CategoryCommandUseCase commandUseCase;
    private final CategoryWebMapper mapper;

    @PostMapping
    public ResponseEntity<Void> create(
            @RequestBody
            @Valid final CategoryRequest request
    ) {
        this.commandUseCase.create(mapper.toCreateCommand(request));
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCategory(
            @RequestBody
            @Valid final CategoryRequest request,
            @PathVariable("id")
            @NotNull(message = "Category ID cannot be null") final String id
    ) {
        this.commandUseCase.update(id, mapper.toUpdateCommand(request));
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable("id")
            @NotNull(message = "Category ID cannot be null") final String id
    ) {
        this.commandUseCase.delete(id);
        return ResponseEntity.ok().build();
    }
}
