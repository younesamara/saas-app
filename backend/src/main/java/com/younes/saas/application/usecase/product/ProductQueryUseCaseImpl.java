package com.younes.saas.application.usecase.product;

import com.younes.saas.application.annotations.Query;
import com.younes.saas.application.common.PageResult;
import com.younes.saas.application.ports.in.product.ProductQueryUseCase;
import com.younes.saas.domain.exceptions.ResourceNotFoundException;
import com.younes.saas.domain.models.Product;
import com.younes.saas.application.ports.out.ProductRepository;

@Query
public class ProductQueryUseCaseImpl implements ProductQueryUseCase {

    private final ProductRepository productRepository;

    public ProductQueryUseCaseImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product getProductById(String id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with ID " + id + " not found"));
    }

    @Override
    public PageResult<Product> listProducts(int page, int size) {
        return productRepository.findAll(page, size);
    }
}
