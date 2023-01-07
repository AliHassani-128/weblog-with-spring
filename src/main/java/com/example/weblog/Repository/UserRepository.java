package com.example.weblog.Repository;

import java.util.List;
import java.util.Optional;

import com.example.weblog.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByUsername(String username);

    public Boolean existsByUsername(String username);

    public List<User> findByFirstName(String firstName);

    public List<User> findByLastName(String lastName);


}