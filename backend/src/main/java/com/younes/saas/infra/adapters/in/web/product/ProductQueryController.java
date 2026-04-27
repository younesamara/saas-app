package com.younes.saas.infra.adapters.in.web.product;

import com.younes.saas.application.common.PageResult;
import com.younes.saas.application.ports.in.product.ProductQueryUseCase;
import com.younes.saas.domain.models.Product;
import com.younes.saas.infra.adapters.in.web.common.PageResponse;
import com.younes.saas.infra.adapters.in.web.product.dto.ProductResponse;
import com.younes.saas.infra.adapters.in.web.product.mapper.ProductMapper;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductQueryController {

    private final ProductQueryUseCase queryUseCase;
    private final ProductMapper mapper;

    @GetMapping
    public ResponseEntity<PageResponse<ProductResponse>> getAllProducts(
            @RequestParam(name = "page", defaultValue = "0") final int page,
            @RequestParam(name = "size", defaultValue = "10") final int size
    ) {
        PageResult<Product> domainProducts = this.queryUseCase.listProducts(page, size);
        PageResponse<ProductResponse> response = mapper.toPageResponse(domainProducts);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(
            @PathVariable("id")
            @NotNull(message = "Product ID cannot be null") final String id
    ) {
        Product product = this.queryUseCase.getProductById(id);
        return ResponseEntity.ok(mapper.toResponse(product));
    }
}
