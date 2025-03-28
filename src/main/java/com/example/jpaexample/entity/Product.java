package com.example.jpaexample.entity;

import com.example.jpaexample.presentation.dto.CreateProductDto;
import com.example.jpaexample.presentation.dto.UpdateProductDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public record Product (
        @Id Long id,
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

}
