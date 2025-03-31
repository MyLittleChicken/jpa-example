package com.example.jpaexample.infrastructure.tobe.inmemory;

import com.example.jpaexample.infrastructure.persistence.ProductPersistence;

import java.util.Optional;

public interface ProductMemoryRepository {

    Optional<ProductPersistence> findById(Long id);

    ProductPersistence save(ProductPersistence product);
}
