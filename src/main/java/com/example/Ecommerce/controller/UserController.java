package com.example.Ecommerce.controller;

import com.example.Ecommerce.model.User;
import com.example.Ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.OK)
    public User save(@RequestBody User user){
        return userService.save(user);
    }
}
