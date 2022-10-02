package com.be.ecommerce.controllers;

import com.be.ecommerce.dto.ProductDTO;
import com.be.ecommerce.entities.Product;
import com.be.ecommerce.mappers.ProductMapper;
import com.be.ecommerce.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/products/")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService, ProductMapper productMapper){
        this.productService = productService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductDTO productDTO){
        productService.addProduct(productDTO);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO getProduct(@PathVariable("id") Long id){
        return productService.getProduct(id);
    }

    @PutMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateProduct(@PathVariable("id") Long id){
    }
}
