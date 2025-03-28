package com.example.jpaexample.infrastructure.tobe;

import com.example.jpaexample.infrastructure.ProductJpaRepository;
import com.example.jpaexample.infrastructure.persistence.ProductPersistence;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProductDataAccessImpl implements ProductDataAccess {

    private final ProductJpaRepository productJpaRepository;

    @Override
    public Optional<List<ProductPersistence>> findAll() {
        return Optional.of(productJpaRepository.findAll());
    }

    @Override
    public Optional<ProductPersistence> findById(final Long id) {
        return productJpaRepository.findById(id);
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
