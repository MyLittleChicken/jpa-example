package com.example.jpaexample.infrastructure.tobe;

import com.example.jpaexample.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDataAccess {

    Optional<List<Product>> findAll();

    Optional<Product> findById(Long id);

    Optional<Product> save(Product product);

    void deleteById(Long id);
}
