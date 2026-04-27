package com.younes.saas.infra.adapters.in.web.category.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryRequest {

    @NotBlank(message = "Category name should not be empty")
    @Size(min = 3, max = 255, message = "Category name should be between 3 and 255 characters")
    private String name;
    private String description;
}