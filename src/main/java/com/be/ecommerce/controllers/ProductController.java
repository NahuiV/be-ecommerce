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
    private final ProductMapper productMapper;

    public ProductController(ProductService productService, ProductMapper productMapper){
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductDTO productDTO){
        Product product = productMapper.convertToEntity(productDTO);
        productService.addProduct(product);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO getProduct(@PathVariable("id") Long id){
        Product product= productService.getProduct(id);
        return productMapper.convertToDto(product);
    }

    @PutMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateProduct(@PathVariable("id") Long id){
    }
}
