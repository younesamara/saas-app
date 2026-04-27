package com.younes.saas.application.services.product;

import com.younes.saas.application.annotations.Query;
import com.younes.saas.domain.exceptions.ResourceNotFoundException;
import com.younes.saas.domain.models.Product;
import com.younes.saas.domain.ports.in.product.GetProductUseCase;
import com.younes.saas.domain.ports.out.product.ProductRepository;

@Query
public class GetProductService implements GetProductUseCase {

    private final ProductRepository productRepository;

    public GetProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product execute(String id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with ID " + id + " not found"));
    }
}
