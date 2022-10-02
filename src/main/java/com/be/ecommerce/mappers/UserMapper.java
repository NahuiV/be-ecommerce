package com.be.ecommerce.mappers;

import com.be.ecommerce.dto.UserDTO;
import com.be.ecommerce.dto.UserRegisterDTO;
import com.be.ecommerce.entities.User;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

@Component
@AllArgsConstructor
public class UserMapper{

    private final ModelMapper modelMapper;

    public UserDTO convertToDto(User user){
        return modelMapper.map(user,UserDTO.class);
    }

    public User convertToEntity(UserDTO userDTO){
        return modelMapper.map(userDTO,User.class);
    }

    public User convertToEntity(UserRegisterDTO userRegisterDTO){
        User user = modelMapper.map(userRegisterDTO,User.class);
        user.setCreatedAt(LocalDate.now());
        user.setModifiedAt(LocalDate.now());
        return user;
    }

}
