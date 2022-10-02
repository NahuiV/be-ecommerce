package com.be.ecommerce.services;

import com.be.ecommerce.constants.Constants;
import com.be.ecommerce.entities.User;
import com.be.ecommerce.exceptions.user.UserExistsException;
import com.be.ecommerce.exceptions.user.UserNotFoundException;
import com.be.ecommerce.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(User user){
        Optional<User> optionalUser = userRepository.findUserByEmail(user.getEmail());
        if(optionalUser.isPresent()){
            throw new UserExistsException(Constants.USER_EXISTS + user.getEmail());
        }
        userRepository.save(user);
    }

    public void deleteUser(Long id){
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException(Constants.USER_NOT_FOUND + id);
        }
        userRepository.deleteById(id);
    }

    public User getUser(Long id){
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent()){
            throw new UserNotFoundException(Constants.USER_NOT_FOUND + id);
        }
        return user.get();
     }

    @Transactional(readOnly = true)
     public List<User> getAllUsers(){
        return userRepository.findAll();
    }
}
