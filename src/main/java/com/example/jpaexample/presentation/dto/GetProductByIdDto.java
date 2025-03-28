package com.example.jpaexample.presentation.dto;

import com.example.jpaexample.entity.Product;

public class GetProductByIdDto {

    public record Response() {

        public static Response fromEntity(final Product product) {
            return new Response();
        }
    }

}
