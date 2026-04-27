package com.younes.saas.infra.adapters.out.persistence.category;

import com.younes.saas.domain.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryJpaRepository extends JpaRepository<JpaCategory, String> {
    Optional<Category> findByNameIgnoreCase(String categoryName);
}
