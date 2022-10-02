package com.be.ecommerce.services;

import com.be.ecommerce.constants.Constants;
import com.be.ecommerce.dto.ProductDTO;
import com.be.ecommerce.entities.Product;
import com.be.ecommerce.exceptions.product.ProductNotFoundException;
import com.be.ecommerce.mappers.ProductMapper;
import com.be.ecommerce.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository,ProductMapper mapper) {
        this.productRepository = productRepository;
        this.productMapper = mapper;
    }

    public void addProduct(Product product){
        productRepository.save(product);
    }

    public void deleteProduct(Long id){
        if(!productRepository.existsById(id)){
            throw new ProductNotFoundException(Constants.PRODUCT_NOT_FOUND + id);
        }
        productRepository.deleteById(id);
    }

    public ProductDTO getProduct(Long id){
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty()){
            throw new ProductNotFoundException(Constants.PRODUCT_NOT_FOUND + id);
        }
        return productMapper.convertToDto(product.get());
    }

    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }
}
