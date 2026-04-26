package com.younes.saas.infra.adapters.out.persistence.stockmvt;

import com.younes.saas.domain.common.PageResult;
import com.younes.saas.domain.models.StockMvt;
import com.younes.saas.domain.ports.out.stockmvt.StockMvtRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public class StockMvtRepositoryImpl implements StockMvtRepository {

    private final StockMvtJpaRepository jpaRepository;
    private final StockMvtJpaMapper mapper;

    public StockMvtRepositoryImpl(StockMvtJpaRepository jpaRepository, StockMvtJpaMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public PageResult<StockMvt> findAll(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<JpaStockMvt> stockMvts = jpaRepository.findAll(pageRequest);

        return mapper.toPageResult(stockMvts);
    }

    @Override
    public Optional<StockMvt> findById(String id) {
        return jpaRepository.findById(id).map(mapper::toDomain);
    }
}
