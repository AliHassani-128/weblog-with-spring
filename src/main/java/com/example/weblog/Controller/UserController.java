package com.example.weblog.Controller;


import com.example.weblog.Entity.User;
import com.example.weblog.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class UserController {
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User findUser = userRepository.findByUserName(user.getUserName());
        if (findUser != null) {
            return ResponseEntity.ok(findUser);
        }
        User newUser = userRepository.save(user);
        return ResponseEntity.ok(newUser);
    }

}
