package com.example.mariaConnection.service;

import com.example.mariaConnection.entity.Post;
import com.example.mariaConnection.entity.User;

import java.util.List;


public interface PostService {
    //마이페이지 user로 찾기
    List<Post> getPostsByUser(User user);

    //공동구매 개시글에 필요한 내용 모두찾기, 특정 아이디로 찾기
    List<Post> getAllPosts();
    Post getPostById(Integer postId);
    Post savePost(Post post);

}
