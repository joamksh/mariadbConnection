package com.example.mariaConnection.service;

import com.example.mariaConnection.entity.Post;
import com.example.mariaConnection.entity.User;
import com.example.mariaConnection.entity.UserLikePost;
import com.example.mariaConnection.repository.PostRepository;
import com.example.mariaConnection.repository.UserLikePostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserLikePostServiceImpl implements UserLikePostService {

    @Autowired
    private UserLikePostRepository userLikePostRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> getLikedPostsByUser(User user) {
        List<UserLikePost> userLikePosts = userLikePostRepository.findByUser(user);
        List<Integer> likedPostIds = userLikePosts.stream().map(UserLikePost::getPostId).collect(Collectors.toList());
        return postRepository.findAllById(likedPostIds);
    }
}