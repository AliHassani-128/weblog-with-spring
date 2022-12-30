package com.example.weblog;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    public User findByUserName(String userName);
    public User findByFirstName(String firstName);
    public List<User> findByLastName(String lastName);
}