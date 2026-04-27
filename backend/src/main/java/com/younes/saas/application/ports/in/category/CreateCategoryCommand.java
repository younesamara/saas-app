package com.younes.saas.application.ports.in.category;

public record CreateCategoryCommand(
        String name,
        String description
) {
}
