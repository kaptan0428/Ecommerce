package com.example.Ecommerce.service;

import com.example.Ecommerce.model.User;
import com.example.Ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    private TokenService tokenService;

    @Autowired
    public UserService(UserRepository userRepository, TokenService tokenService) {
        this.userRepository = userRepository;
        this.tokenService = tokenService;
    }

    // Create user
    public User saveUserService(User user){
        return userRepository.save(user);
    }

    // Read user by user ID
    public User findUserService(int id){
        Optional<User> userRes = userRepository.findById(id);
        return userRes.orElse(null);
    }

    // Delete user by user ID
    public void deleteUserService(int id){
        Optional<User> userRes = userRepository.findById(id);
        if(userRes.isEmpty()){
            return;
        }
        userRepository.deleteById(id);
    }

    //update user
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



    public String userLoginService(String email, String password){
        if(!findByEmail(email))
            return "{" +
                "\"message\":"+"Authentication Failed\",\n"+
                "}";

        User user = userRepository.getUserByUserName(email);
        if(!user.getPassword().equals(password))
            return "{" +
                "\"message\":"+"Authentication Failed\",\n"+
                "}";

        return "{" +
                "\"message\":"+"Successfully Logged in\",\n"+
                "\"data\": "+user+",\n"+
                "\"Email: " + user.getEmail() + "\n"+
                "\"token: " + tokenService.createTokenFunction(user.getId()) +
                "}";
    }
}
