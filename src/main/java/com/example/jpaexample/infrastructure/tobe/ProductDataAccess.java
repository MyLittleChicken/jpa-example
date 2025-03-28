package com.example.jpaexample.infrastructure.tobe;

import com.example.jpaexample.infrastructure.persistence.ProductPersistence;

import java.util.List;
import java.util.Optional;

public interface ProductDataAccess {

    Optional<List<ProductPersistence>> findAll();

    Optional<ProductPersistence> findById(Long id);

    Optional<ProductPersistence> save(ProductPersistence product);

    void deleteById(Long id);
}
