package com.younes.saas.infra.adapters.out.persistence.config;

import com.younes.saas.application.annotations.Command;
import com.younes.saas.application.annotations.Query;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
@RequiredArgsConstructor
public class TransactionalUseCaseAspect {

    private final TransactionalUseCaseExecutor executor;

    @Pointcut("@within(query)")
    void inQuery(Query query) {}

    @Pointcut("@within(command)")
    void inCommand(Command command) {}

    @Around("inQuery(query)")
    Object useQuery(ProceedingJoinPoint joinPoint, Query query) {
        return executor.executeQuery(() -> proceed(joinPoint));
    }

    @Around("inCommand(command)")
    Object useCommand(ProceedingJoinPoint joinPoint, Command command) {
        return executor.executeCommand(() -> proceed(joinPoint));
    }

    @SneakyThrows
    private static Object proceed(ProceedingJoinPoint joinPoint) {
        return joinPoint.proceed();
    }
}