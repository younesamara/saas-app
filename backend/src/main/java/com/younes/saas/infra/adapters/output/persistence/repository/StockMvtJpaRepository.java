package com.younes.saas.infra.adapters.output.persistence.repository;

import com.younes.saas.infra.adapters.output.persistence.models.StockMvtEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockMvtJpaRepository extends JpaRepository<StockMvtEntity, String> {
}
