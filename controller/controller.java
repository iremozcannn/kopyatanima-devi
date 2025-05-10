package com.kopyatanimabackend.controller;

import com.example.plagiarismdetector.model.User;
import com.example.plagiarismdetector.security.JwtTokenUtil;
import com.example.plagiarismdetector.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class controller {
	  @Autowired
	    private UserService userService;

	    @Autowired
	    private JwtTokenUtil jwtTokenUtil;

	    @PostMapping("/login")
	    public String login(@RequestBody User user) {
	        if (userService.authenticate(user)) {
	            return jwtTokenUtil.generateToken(user.getUsername());
	        }
	        return "Invalid credentials";
	    }

	    @PostMapping("/register")
	    public String register(@RequestBody User user) {
	        userService.saveUser(user);
	        return "User registered successfully";
	    }
	

}
