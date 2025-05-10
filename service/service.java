package com.kopyatanimabackend.service;

import com.example.plagiarismdetector.model.User;
import com.example.plagiarismdetector.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service



public class service {

	 @Autowired
	    private UserRepository userRepository;

	    public void saveUser(User user) {
	        userRepository.save(user);
	    }

	    public boolean authenticate(User user) {
	        User storedUser = userRepository.findById(user.getUsername()).orElse(null);
	        return storedUser != null && storedUser.getPassword().equals(user.getPassword());
	    }
	
	
}
