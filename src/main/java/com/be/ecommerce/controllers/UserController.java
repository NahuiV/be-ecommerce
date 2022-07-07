package com.be.ecommerce.controllers;

import com.be.ecommerce.dto.UserDTO;
import com.be.ecommerce.entities.User;
import com.be.ecommerce.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {

    private final UserService userService;

    @Autowired
    private ModelMapper userMapper;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody UserDTO userDTO){
        User user = userMapper.map(userDTO,User.class);
        userService.addUser(user);
    }

    @GetMapping
    public UserDTO getUser(@PathVariable("id") Long id){
        User user = userService.getUser(id);
        return userMapper.map(user,UserDTO.class);
    }

    @PutMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateUser(@PathVariable("id") Long id){
    }
}
