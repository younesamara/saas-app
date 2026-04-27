package com.younes.saas.infra.adapters.out.persistence.config;

import org.springframework.transaction.annotation.Transactional;

import java.util.function.Supplier;

public class TransactionalUseCaseExecutor {

    @Transactional
    <T> T executeInTransaction(Supplier<T> execution) {
        return execution.get();
    }

    @Transactional
    <T> T executeCommand(Supplier<T> execution) {
        return execution.get();
    }

    @Transactional(readOnly = true)
    <T> T executeQuery(Supplier<T> execution) {
        return execution.get();
    }
}
