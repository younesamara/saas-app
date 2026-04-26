package com.younes.saas.infra.adapters.out.persistence.product;

import com.younes.saas.domain.common.PageResult;
import com.younes.saas.domain.models.Product;
import com.younes.saas.domain.ports.out.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductJpaRepository jpaRepository;
    private final ProductJpaMapper mapper;

    @Override
    public PageResult<Product> findAll(int page, int size) {

        PageRequest pageRequest = PageRequest.of(page, size);
        Page<JpaProduct> products = jpaRepository.findAll(pageRequest);
        return mapper.toPageResult(products);

    }

    @Override
    public Optional<Product> findById(String id) {

        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }
}
