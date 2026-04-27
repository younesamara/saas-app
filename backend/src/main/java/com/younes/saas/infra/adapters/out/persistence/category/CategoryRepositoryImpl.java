package com.younes.saas.infra.adapters.out.persistence.category;

import com.younes.saas.application.common.PageResult;
import com.younes.saas.domain.exceptions.ResourceNotFoundException;
import com.younes.saas.domain.models.Category;
import com.younes.saas.application.ports.out.CategoryRepository;
import com.younes.saas.infra.adapters.out.persistence.exceptions.DuplicateResourceException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
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

    @Override
    public void save(Category category) {

        checkIfCategoryAlreadyExistsByName(category.getName());
        JpaCategory jpaCategory = mapper.toJpaEntity(category);

        this.jpaRepository.save(jpaCategory);
    }

    @Override
    public void delete(String id) {
        final JpaCategory category = this.jpaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category does not exist"));
        this.jpaRepository.delete(category);
    }

    @Override
    public void update(String id, Category category) {

        final Optional<JpaCategory> existingCategory = this.jpaRepository.findById(id);

        if (existingCategory.isEmpty()) {
            log.debug("Category does not exist");
            throw new ResourceNotFoundException("Category does Not exist");
        }

        if (!existingCategory.get().getName().equalsIgnoreCase(category.getName())) {
            checkIfCategoryAlreadyExistsByName(category.getName());
        }
        JpaCategory categoryToUpdate = this.mapper.toJpaEntity(category);
        categoryToUpdate.setId(id);
        this.jpaRepository.save(categoryToUpdate);

    }

    private void checkIfCategoryAlreadyExistsByName(final String categoryName) {
        final Optional<Category> category = this.jpaRepository.findByNameIgnoreCase(categoryName);
        if (category.isPresent()) {
            log.warn("Category already exists");
            throw new DuplicateResourceException("Category already exists");
        }
    }
}
