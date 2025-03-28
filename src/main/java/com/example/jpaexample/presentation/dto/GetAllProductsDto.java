package com.example.jpaexample.presentation.dto;

import com.example.jpaexample.entity.Product;

import java.util.List;

public class GetAllProductsDto {

    public record Response() {

        public static Response fromEntity(Product product) {
            return new Response();
        }

        public static Response fromEntities(final List<Product> product) {
            return new Response();
        }
    }

}
