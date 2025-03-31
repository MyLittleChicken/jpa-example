package com.example.jpaexample.infrastructure.tobe.inmemory;

import com.example.jpaexample.infrastructure.persistence.ProductPersistence;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ProductMemoryRepositoryImpl implements ProductMemoryRepository {

    /**
     * In-memory cache store for ProductPersistence entities.
     */
    private final Map<Long, ProductPersistence> cacheStore = new ConcurrentHashMap<>();

    @Override
    public Optional<ProductPersistence> findById(Long id) {
        return Optional.ofNullable(cacheStore.get(id));
    }

    @Override
    public ProductPersistence save(ProductPersistence product) {
        cacheStore.put(product.getId(), product);
        return product;
    }
}
