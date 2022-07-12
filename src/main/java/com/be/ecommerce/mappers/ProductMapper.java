package com.be.ecommerce.mappers;

import com.be.ecommerce.dto.ProductDTO;
import com.be.ecommerce.dto.UserDTO;
import com.be.ecommerce.entities.Product;
import com.be.ecommerce.entities.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    private final ModelMapper productMapper;

    public ProductMapper(){
        this.productMapper = new ModelMapper();
    }

    public ProductDTO convertToDto(Product product){
        ProductDTO productDTO = productMapper.map(product,ProductDTO.class);
        return productDTO;
    }

    public Product convertToEntity(ProductDTO productDTO){
        Product product = productMapper.map(productDTO,Product.class);
        return product;
    }
}
