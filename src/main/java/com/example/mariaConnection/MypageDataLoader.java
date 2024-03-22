package com.example.mariaConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class MypageDataLoader {

    @Autowired
    private PostRepository postRepository;

    @Autowired PostIngredientRepository postIngredientRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserLikePostRepository userLikePostRepository;

    public void loadData() {
        createUserPostLike();
    }

    private void createUserPostLike(){
        User user = new User();
        user.setId("aaa");
        user.setRating(5); // 임의의 값 설정
        user.setProfile("프로필");
        user.setNickname("수현");
        userRepository.save(user);

        UserLikePost userLikePost = new UserLikePost();
        userLikePost.setUser(user);
        userLikePost.setPostId(5);
        userLikePostRepository.save(userLikePost);

        Post post = new Post();
        post.setPrice(1000); // 임의의 값 설정
        post.setCreatedAt(LocalDateTime.now()); // 현재 시간 설정
        post.setClosedAt(LocalDateTime.now());
        post.setTitle("postTitle");
        post.setImages("postImages");
        post.setGroupSize(5);
        post.setCurGroupSize(2);
        post.setUser(user);
        postRepository.save(post);


        PostIngredient ingredient = new PostIngredient();
        ingredient.setName("감자");
        ingredient.setPost(post);
        postIngredientRepository.save(ingredient);


    }

}
