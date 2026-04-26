package com.younes.saas.infra.adapters.out.persistence.category;

import com.younes.saas.domain.common.PageResult;
import com.younes.saas.domain.models.Category;
import com.younes.saas.domain.ports.out.category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CategoryRepositoryImpl implements CategoryRepository {

    private final CategoryJpaRepository jpaRepository;
    private final CategoryJpaMapper mapper;


    @Override
    public PageResult<Category> findAll(int page, int size) {

        PageRequest pageRequest = PageRequest.of(page, size);
        Page<JpaCategory> categories = jpaRepository.findAll(pageRequest);

        return mapper.toPageResult(categories);
    }

    @Override
    public Optional<Category> findById(String id) {
        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }
}
