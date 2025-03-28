package com.example.jpaexample.presentation.dto;

import com.example.jpaexample.entity.Product;

public class CreateProductDto {

    public record Request(
            String name,
            String description,
            Integer price
    ) {

    }

    public record Response(
            Long id,
            String name,
            String description,
            Integer price
    ) {

        public static Response fromEntity(final Product product) {
            return new Response(product.id(), product.name(), product.description(), product.price());
        }
    }

}
