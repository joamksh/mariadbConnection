package com.example.mariaConnection.service;

import com.example.mariaConnection.entity.Post;
import com.example.mariaConnection.entity.User;

import java.util.List;


public interface PostService {
    List<Post> getPostsByUser(User user);
}
