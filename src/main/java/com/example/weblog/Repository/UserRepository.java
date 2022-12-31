package com.example.weblog.Repository;

import java.util.List;

import com.example.weblog.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    public User findByUserName(String userName);

    public User findByFirstName(String firstName);

    public List<User> findByLastName(String lastName);
}