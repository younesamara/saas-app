package com.younes.saas.infra.adapters.out.persistence.category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryJpaRepository extends JpaRepository<JpaCategory, String> {
}
