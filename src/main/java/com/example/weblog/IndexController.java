package com.example.weblog;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class IndexController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/index")
    public String index(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s", name);
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam(value = "userName") String userName,
                               @RequestParam(value = "password") String password,
                               @RequestParam(value = "firstName") String firstName,
                               @RequestParam(value = "lastName") String lastName) {
        userRepository.save(new User(userName, password, firstName, lastName));
        return userRepository.findByUserName(userName).toString();
    }
}
