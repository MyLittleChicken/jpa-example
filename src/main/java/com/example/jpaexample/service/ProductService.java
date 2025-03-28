package com.example.jpaexample.service;

import com.example.jpaexample.entity.Product;
import com.example.jpaexample.presentation.dto.CreateProductDto;
import com.example.jpaexample.presentation.dto.DeleteProductDto;
import com.example.jpaexample.presentation.dto.UpdateProductDto;

import java.util.List;

public interface ProductService {

        List<Product> getAllProducts();

        Product getProductById(Long id);

        Product createProduct(CreateProductDto.Request request);

        Product updateProduct(UpdateProductDto.Request request);

        void deleteProduct(DeleteProductDto.Request request);
}
