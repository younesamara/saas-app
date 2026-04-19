package com.younes.saas.infra.adapters.output.persistence.repository;

import com.younes.saas.domain.models.StockMvt;
import com.younes.saas.domain.ports.output.StockMvtRepository;
import com.younes.saas.infra.adapters.output.persistence.mappers.StockMvtMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StockMvtRepositoryImpl implements StockMvtRepository {

    private final StockMvtJpaRepository jpaRepository;
    private final StockMvtMapper mapper;

    public StockMvtRepositoryImpl(StockMvtJpaRepository jpaRepository, StockMvtMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public List<StockMvt> findAll() {
        return jpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }
}
