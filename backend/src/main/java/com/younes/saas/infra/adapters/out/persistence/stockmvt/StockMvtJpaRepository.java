package com.younes.saas.infra.adapters.out.persistence.stockmvt;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockMvtJpaRepository extends JpaRepository<JpaStockMvt, String> {
}
