package com.example.weblog;

import org.springframework.data.annotation.Id;

public class User {
    @Id
    public String id;
    public String userName;
    public String password;
    public String firstName;
    public String lastName;

    public User(String userName, String password, String firstName, String lastName){
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString(){
        return String.format("User[id=%s, userName='%s']",id, userName);
    }
}
