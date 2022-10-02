package com.be.ecommerce.services;

import com.be.ecommerce.constants.Constants;
import com.be.ecommerce.dto.ProductDTO;
import com.be.ecommerce.entities.Product;
import com.be.ecommerce.exceptions.product.ProductNotFoundException;
import com.be.ecommerce.mappers.ProductMapper;
import com.be.ecommerce.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {

    private static final Logger LOGGER  = LoggerFactory.getLogger(ProductService.class);

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository,ProductMapper mapper) {
        this.productRepository = productRepository;
        this.productMapper = mapper;
    }

    /**
     * Add a product.
     * @param productDTO
     */
    public void addProduct(ProductDTO productDTO){
        Product product = productMapper.convertToEntity(productDTO);
        productRepository.save(product);
        LOGGER.info("Product added successfully");
    }

    /**
     * Delete a product. If not exists throw exception.
     * @param id
     * @throws ProductNotFoundException - Product not found
     */
    public void deleteProduct(Long id){
        if(!productRepository.existsById(id)){
            throw new ProductNotFoundException(Constants.PRODUCT_NOT_FOUND + id);
        }
        productRepository.deleteById(id);
        LOGGER.info("Product deleted successfully");
    }

    /**
     * Get a product. If not exists throw exception.
     * @param id
     * @throws ProductNotFoundException - Product not found
     * @return Product convert to DTO
     */
    @Transactional(readOnly = true)
    public ProductDTO getProduct(Long id){
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty()){
            throw new ProductNotFoundException(Constants.PRODUCT_NOT_FOUND + id);
        }
        return productMapper.convertToDto(product.get());
    }

    /**
     * Get all products.
     * @return Lists of productsDTO
     */
    @Transactional(readOnly = true)
    public List<ProductDTO> getAllProduct(){
        List<ProductDTO> productDTOS = new ArrayList<>();
        List<Product> products = productRepository.findAll();
        for (Product product: products){
            productDTOS.add(productMapper.convertToDto(product));
        }

        return productDTOS;
    }
}
