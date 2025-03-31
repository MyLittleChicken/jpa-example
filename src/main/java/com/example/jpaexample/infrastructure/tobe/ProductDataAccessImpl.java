package com.example.jpaexample.infrastructure.tobe;

import com.example.jpaexample.infrastructure.tobe.inmemory.ProductMemoryRepository;
import com.example.jpaexample.infrastructure.tobe.rdb.ProductJpaRepository;
import com.example.jpaexample.infrastructure.persistence.ProductPersistence;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProductDataAccessImpl implements ProductDataAccess {

    private final ProductJpaRepository productJpaRepository;
    private final ProductMemoryRepository productMemoryRepository;

    @Override
    public Optional<List<ProductPersistence>> findAll() {
        return Optional.of(productJpaRepository.findAll());
    }

    @Override
    public Optional<ProductPersistence> findById(final Long id) {
        return productMemoryRepository.findById(id)
                .or(() -> productJpaRepository.findById(id)
                        .map(productMemoryRepository::save)
                );
    }

    @Override
    public Optional<ProductPersistence> save(final ProductPersistence product) {
        return Optional.of(productJpaRepository.save(product));
    }

    @Override
    public void deleteById(final Long id) {
        productJpaRepository.deleteById(id);
    }
}
