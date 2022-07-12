package com.be.ecommerce.controllers;

import com.be.ecommerce.dto.UserDTO;
import com.be.ecommerce.entities.User;
import com.be.ecommerce.mappers.UserMapper;
import com.be.ecommerce.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/users/")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper){
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody UserDTO userDTO){
        User user = userMapper.convertToEntity(userDTO);
        userService.addUser(user);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public UserDTO getUser(@PathVariable("id") Long id){
        User user = userService.getUser(id);
        return userMapper.convertToDto(user);
    }

    @PutMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateUser(@PathVariable("id") Long id){
    }
}
