package com.example.jpaexample.presentation.dto;

import com.example.jpaexample.domain.Product;

public class UpdateProductDto {

    public record Request(
            Long id,
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
