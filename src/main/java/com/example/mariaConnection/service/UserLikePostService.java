package com.example.mariaConnection.service;

import com.example.mariaConnection.entity.Post;
import com.example.mariaConnection.entity.User;

import java.util.List;

public interface UserLikePostService {
    List<Post> getLikedPostsByUser(User user);
}
