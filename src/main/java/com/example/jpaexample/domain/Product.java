package com.example.jpaexample.domain;

import com.example.jpaexample.infrastructure.persistence.ProductPersistence;
import com.example.jpaexample.presentation.dto.CreateProductDto;
import com.example.jpaexample.presentation.dto.UpdateProductDto;

public record Product (
        Long id,
        String name,
        String description,
        Integer price
) {

    public static Product fromRequest(final CreateProductDto.Request request) {
        return new Product(null, request.name(), request.description(), request.price());
    }

    public static Product fromRequest(final UpdateProductDto.Request request) {
        return new Product(request.id(), request.name(), request.description(), request.price());
    }

    public static Product fromPersistence(final ProductPersistence productPersistence) {
        return new Product(
                productPersistence.getId(),
                productPersistence.getName(),
                productPersistence.getDescription(),
                productPersistence.getPrice()
        );
    }

}
