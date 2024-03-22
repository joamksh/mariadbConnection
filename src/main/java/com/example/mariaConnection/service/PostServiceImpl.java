package com.example.mariaConnection.service;

import com.example.mariaConnection.entity.Post;
import com.example.mariaConnection.entity.User;
import com.example.mariaConnection.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> getPostsByUser(User user) {
        return postRepository.findByUser(user);
    }
}