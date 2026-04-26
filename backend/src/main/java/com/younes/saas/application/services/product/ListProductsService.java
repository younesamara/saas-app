package com.younes.saas.application.services.product;

import com.younes.saas.application.annotations.UseCase;
import com.younes.saas.domain.common.PageResult;
import com.younes.saas.domain.models.Product;
import com.younes.saas.domain.ports.in.product.ListProductsUseCase;
import com.younes.saas.domain.ports.out.product.ProductRepository;

@UseCase
public class ListProductsService implements ListProductsUseCase {

    private final ProductRepository productRepository;

    public ListProductsService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public PageResult<Product> execute(int page, int size) {
        return productRepository.findAll(page, size);
    }
}
