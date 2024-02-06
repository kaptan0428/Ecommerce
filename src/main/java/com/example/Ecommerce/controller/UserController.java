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
    public User saveUser(@RequestBody User user){
        return userService.saveUserService(user);
    }

    @GetMapping("/finduser/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User findUser(@PathVariable int id){
        return userService.findUserService(id);
    }

    @DeleteMapping("/deleteuser/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable int id){
        userService.deleteUserService(id);
    }

    @PostMapping("/updateuser/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User updateUser(@RequestBody User user, @PathVariable int id){
        return userService.updateUserService(user, id);
    }

    @PostMapping("/existbyemail")
    public boolean existByEmail(@RequestBody User user){
        String email = user.getEmail();
        return userService.findByEmail(email);
    }

}
