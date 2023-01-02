package com.example.weblog.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class IndexController {

    @GetMapping("/index")
    public String index(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s", name);
    }

}
