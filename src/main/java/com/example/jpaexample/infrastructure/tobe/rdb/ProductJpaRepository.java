package com.example.jpaexample.infrastructure.tobe.rdb;

import com.example.jpaexample.infrastructure.persistence.ProductPersistence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpaRepository extends JpaRepository<ProductPersistence, Long> {
}
