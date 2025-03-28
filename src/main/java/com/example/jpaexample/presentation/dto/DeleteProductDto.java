package com.example.jpaexample.presentation.dto;

import com.example.jpaexample.domain.Product;

public class DeleteProductDto {

    public record Request(
            Long id
    ) {

    }

    public record Response(
            Long id
    ) {

        public static Response fromEntity(final Product product) {
            return new Response(product.id());
        }
    }
}
