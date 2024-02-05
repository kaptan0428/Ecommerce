package com.example.Ecommerce.model;

import jakarta.persistence.*;
import lombok.Data;

import java.security.SecureRandom;

@Entity
@Data
@Table(name = "ecommerce_user")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private int id;
    @Column(name = "user_first_name")
    private String  fName;
    @Column(name = "user_last_name")
    private String lName;
    @Column(name = "user_email")
    private String email;
    @Column(name = "user_password")
    private String password;
    @Column(name = "user_address")
    private String address;
    @Column(name = "user_date_of_birth")
    private String DOB;
    @Column(name = "user_mobile")
    private String mobile;
}
