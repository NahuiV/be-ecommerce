package com.be.ecommerce.services;

import com.be.ecommerce.constants.Constants;
import com.be.ecommerce.entities.Product;
import com.be.ecommerce.exceptions.product.ProductNotFoundException;
import com.be.ecommerce.exceptions.user.UserNotFoundException;
import com.be.ecommerce.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
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

    public Product getProduct(Long id){
        Optional<Product> product = productRepository.findById(id);
        if(!product.isPresent()){
            throw new ProductNotFoundException(Constants.PRODUCT_NOT_FOUND + id);
        }
        return product.get();
    }

    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }
}
