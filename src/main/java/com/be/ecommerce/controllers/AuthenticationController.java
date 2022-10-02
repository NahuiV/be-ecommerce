package com.be.ecommerce.controllers;

import com.be.ecommerce.dto.LoginDTO;
import com.be.ecommerce.dto.UserRegisterDTO;
import com.be.ecommerce.entities.User;
import com.be.ecommerce.mappers.UserMapper;
import com.be.ecommerce.security.config.JwtUtils;
import com.be.ecommerce.services.AuthenticationService;
import com.be.ecommerce.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/api/v1/auth")
@AllArgsConstructor
public class AuthenticationController {

    private final JwtUtils jwtUtils;
    private final UserService userService;
    private final AuthenticationService authenticationService;
    private final UserMapper userMapper;

    @PostMapping("/signin")
    public void register(@RequestBody UserRegisterDTO userRegisterDTO){
        User user = userMapper.convertToEntity(userRegisterDTO);
        userService.addUser(user);
    }

    @PostMapping("/signup")
    public void login(@RequestBody LoginDTO loginDTO){
            authenticationService.validateToken();
    }

    @PostMapping("/signout")
    public void logout(){

    }

}
