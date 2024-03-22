package com.example.mariaConnection.service;

import com.example.mariaConnection.entity.User;
import com.example.mariaConnection.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserById(String userId) {
        return userRepository.findById(userId).orElse(null);
    }
}
