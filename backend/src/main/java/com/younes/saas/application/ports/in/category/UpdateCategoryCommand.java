package com.younes.saas.application.ports.in.category;

public record UpdateCategoryCommand(
        String name,
        String description
) {
}
