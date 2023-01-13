package com.example.weblog.Controller;


import com.example.weblog.Models.User;
import com.example.weblog.Payload.Response;
import com.example.weblog.Repository.UserRepository;
import com.example.weblog.Security.jwt.JwtUtils;
import com.example.weblog.Payload.LoginRequest;
import com.example.weblog.Security.services.UserDetailsImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    PasswordEncoder encoder;


    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
           return ResponseEntity.badRequest()
                    .body(new Response("Error: Username is already taken!"));
        }
        User newUser = new User(user.getUsername(),
                                encoder.encode(user.getPassword()),
                                user.getFirstName(),
                                user.getLastName());
        userRepository.save(newUser);
        return ResponseEntity.ok(new Response("User registered successfully!"));
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImplement userDetails = (UserDetailsImplement) authentication.getPrincipal();

        ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);
        Map<Object, Object> response = new HashMap<>();
        response.put("token", jwtCookie.getValue());
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
                .body(response);

    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/allUsers")
    public List<User> getAllUsers(@AuthenticationPrincipal User user) {
        return userRepository.findAll();
    }

}
