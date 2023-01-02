package com.example.weblog.Controller;

import com.example.weblog.Entity.User;
import com.example.weblog.Repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class IndexController {
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/index")
    public User index(@RequestParam(value = "name", defaultValue = "World") String name) {
//        return String.format("Hello %s", name);
        return new User(counter.incrementAndGet(), "ali", "password", "Ali", "Hassani");
    }


}
