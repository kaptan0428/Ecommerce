package com.example.Ecommerce.service;

import com.example.Ecommerce.model.User;
import com.example.Ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User save(User user){
        return userRepository.save(user);
    }

//    public User userRes = (user) -> {
//        userRepository.save(user);
//    };
}
