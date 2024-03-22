//package com.example.mariaConnection.service;
//
//import com.example.mariaConnection.entity.Post;
//import com.example.mariaConnection.PostRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//@Service
//public class PostServiceImpl implements PostService {
//    private final PostRepository postRepository;
//
//    @Autowired
//    public PostServiceImpl(PostRepository postRepository) {
//        this.postRepository = postRepository;
//    }
//
//    // 모든 게시물 조회
//    public List<Post> getAllPosts() {
//        return postRepository.findAll();
//    }
//
//    // 특정 게시물 조회
//    public Post getPostById(Integer postId) {
//        return postRepository.findById(postId).orElse(null);
//    }
//
//    @Override
//    public Post savePost(Post post) {
//        return postRepository.save(post);
//    }
//}
