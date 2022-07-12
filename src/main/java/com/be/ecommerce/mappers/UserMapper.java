package com.be.ecommerce.mappers;

import com.be.ecommerce.dto.UserDTO;
import com.be.ecommerce.entities.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper{

    private final ModelMapper userMapper;

    public UserMapper(){
        this.userMapper = new ModelMapper();
    }

    public UserDTO convertToDto(User user){
        UserDTO userDTO = userMapper.map(user,UserDTO.class);
        return userDTO;
    }

    public User convertToEntity(UserDTO userDTO){
        User user = userMapper.map(userDTO,User.class);
        return user;
    }


}
