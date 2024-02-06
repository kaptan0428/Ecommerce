package com.example.Ecommerce.repository;

import com.example.Ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    // SELECT * FROM USER WHERE EMAIL=:USERNAME
    @Query("SELECT u FROM User u WHERE u.email = :userName")
    User getUserByUserName(String userName);
}
