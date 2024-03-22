package com.example.mariaConnection.service;

import com.example.mariaConnection.entity.Post;
import com.example.mariaConnection.entity.User;

public interface UserService {
    User getUserById(String userId);

    void saveUser(User user);
}
