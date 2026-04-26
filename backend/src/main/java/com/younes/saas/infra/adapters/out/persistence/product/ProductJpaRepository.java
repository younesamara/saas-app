package com.younes.saas.infra.adapters.out.persistence.product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpaRepository extends JpaRepository<JpaProduct,String> {
}
