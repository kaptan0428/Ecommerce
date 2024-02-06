package com.example.Ecommerce.service;

import com.example.Ecommerce.model.User;
import com.example.Ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    // Create
    public User saveUserService(User user){
        return userRepository.save(user);
    }

    // Read
    public User findUserService(int id){
        Optional<User> userRes = userRepository.findById(id);
        return userRes.orElse(null);
    }

    // Delete
    public void deleteUserService(int id){
        Optional<User> userRes = userRepository.findById(id);
        if(userRes.isEmpty()){
            return;
        }
        userRepository.deleteById(id);
    }

    //update
    public User updateUserService(User user, int id){
        Optional<User> userRes = userRepository.findById(id);
        if(!userRes.isEmpty()){
            deleteUserService(id);
        }
        User res = saveUserService(user);
        res.setId(id);
        return res;
    }

    // saveAll()

    // saveAll an flush()

//    public User userRes = (user) -> {
//        userRepository.save(user);
//    };

//    public String userLoginService(String userName, String password){
//        List<User> foundUsers = userRepository.
//    }

    public boolean findByEmail(String email){
        Optional<User> userFound = Optional.ofNullable(userRepository.getUserByUserName(email));
        return userFound.isPresent();
    }
}
