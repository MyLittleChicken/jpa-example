package com.example.jpaexample.infrastructure.persistence;

import com.example.jpaexample.domain.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductPersistence {
    @Id
    private Long id;
    private String name;
    private String description;
    private Integer price;

    public static ProductPersistence fromDomain(final Product product) {
        return new ProductPersistence(product.id(), product.name(), product.description(), product.price());
    }
}
