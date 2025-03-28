package com.example.jpaexample.service;

import com.example.jpaexample.domain.Product;
import com.example.jpaexample.infrastructure.persistence.ProductPersistence;
import com.example.jpaexample.infrastructure.tobe.ProductDataAccess;
import com.example.jpaexample.presentation.dto.CreateProductDto;
import com.example.jpaexample.presentation.dto.DeleteProductDto;
import com.example.jpaexample.presentation.dto.UpdateProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductDataAccess productDataAccess;

    @Override
    public List<Product> getAllProducts() {
        return productDataAccess.findAll()
                .filter(products -> !products.isEmpty())
                .orElseThrow()
                .stream()
                .map(Product::fromPersistence)
                .toList();
    }

    @Override
    public Product getProductById(final Long id) {
        return Product.fromPersistence(
                productDataAccess.findById(id).orElseThrow()
        );
    }

    @Override
    @Transactional
    public Product createProduct(final CreateProductDto.Request request) {
        Product product = Product.fromRequest(request);
        return Product.fromPersistence(
                productDataAccess.save(ProductPersistence.fromDomain(product)).orElseThrow()
        );
    }

    @Override
    @Transactional
    public Product updateProduct(final UpdateProductDto.Request request) {
        Product product = Product.fromRequest(request);
        return Product.fromPersistence(
                productDataAccess.save(ProductPersistence.fromDomain(product)).orElseThrow()
        );
    }

    @Override
    @Transactional
    public void deleteProduct(final DeleteProductDto.Request request) {
        productDataAccess.deleteById(request.id());
    }
}
