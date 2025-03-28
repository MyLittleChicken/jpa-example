package com.example.jpaexample.service;

import com.example.jpaexample.entity.Product;
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
                .orElseThrow();
    }

    @Override
    public Product getProductById(final Long id) {
        return productDataAccess.findById(id).orElseThrow();
    }

    @Override
    @Transactional
    public Product createProduct(final CreateProductDto.Request request) {
        return productDataAccess.save(Product.fromRequest(request)).orElseThrow();
    }

    @Override
    @Transactional
    public Product updateProduct(final UpdateProductDto.Request request) {
        return productDataAccess.save(Product.fromRequest(request)).orElseThrow();
    }

    @Override
    @Transactional
    public void deleteProduct(final DeleteProductDto.Request request) {
        productDataAccess.deleteById(request.id());
    }
}
