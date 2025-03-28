package com.example.jpaexample.presentation;

import com.example.jpaexample.presentation.dto.*;
import com.example.jpaexample.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public GetAllProductsDto.Response getAllProducts() {
        return GetAllProductsDto.Response.fromEntities(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public GetProductByIdDto.Response getProductById(@PathVariable(name = "id") final Long id) {
        return GetProductByIdDto.Response.fromEntity(productService.getProductById(id));
    }

    @PostMapping
    public CreateProductDto.Response createProduct(@RequestBody final CreateProductDto.Request request) {
        return CreateProductDto.Response.fromEntity(productService.createProduct(request));
    }

    @PatchMapping
    public UpdateProductDto.Response updateProduct(@RequestBody final UpdateProductDto.Request request) {
        return UpdateProductDto.Response.fromEntity(productService.updateProduct(request));
    }

    @DeleteMapping
    public void deleteProduct(@RequestBody final DeleteProductDto.Request request) {
        productService.deleteProduct(request);
    }

}
