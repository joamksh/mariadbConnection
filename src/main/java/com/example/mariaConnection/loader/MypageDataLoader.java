package com.example.mariaConnection.loader;

import com.example.mariaConnection.entity.Post;
import com.example.mariaConnection.entity.PostIngredient;
import com.example.mariaConnection.entity.User;
import com.example.mariaConnection.entity.UserLikePost;
import com.example.mariaConnection.repository.PostIngredientRepository;
import com.example.mariaConnection.repository.PostRepository;
import com.example.mariaConnection.repository.UserLikePostRepository;
import com.example.mariaConnection.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MypageDataLoader {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostIngredientRepository postIngredientRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserLikePostRepository userLikePostRepository;

    public void loadData() {
        createUserAndPosts(); // 사용자와 게시물 데이터 생성
        setUserPostLike(); // 사용자가 좋아하는 게시물 설정
    }

    private void createUserAndPosts() {
        // 사용자 "aaa" 생성
        User userA = new User();
        userA.setId("aaa");
        userA.setRating(5); // 임의의 값 설정
        userA.setProfile("프로필");
        userA.setNickname("수현");
        userRepository.save(userA);

        // 사용자 "bbb" 생성
        User userB = new User();
        userB.setId("bbb");
        userB.setRating(5); // 임의의 값 설정
        userB.setProfile("프로필");
        userB.setNickname("준영");
        userRepository.save(userB);

        // 사용자 "aaa"가 작성한 게시물 설정
        Post post1 = new Post();
        post1.setPrice(1000); // 임의의 값 설정
        post1.setCreatedAt(LocalDateTime.now()); // 현재 시간 설정
        post1.setClosedAt(LocalDateTime.now());
        post1.setTitle("게시물 제목 1");
        post1.setImages("게시물 이미지 1");
        post1.setGroupSize(5);
        post1.setCurGroupSize(2);
        post1.setUser(userA);
        postRepository.save(post1);

        Post post2 = new Post();
        post2.setPrice(1500); // 임의의 값 설정
        post2.setCreatedAt(LocalDateTime.now()); // 현재 시간 설정
        post2.setClosedAt(LocalDateTime.now());
        post2.setTitle("게시물 제목 2");
        post2.setImages("게시물 이미지 2");
        post2.setGroupSize(3);
        post2.setCurGroupSize(1);
        post2.setUser(userA);
        postRepository.save(post2);

        // 사용자 "bbb"가 작성한 게시물 설정
        Post post3 = new Post();
        post3.setPrice(2000); // 임의의 값 설정
        post3.setCreatedAt(LocalDateTime.now()); // 현재 시간 설정
        post3.setClosedAt(LocalDateTime.now());
        post3.setTitle("게시물 제목 3");
        post3.setImages("게시물 이미지 3");
        post3.setGroupSize(4);
        post3.setCurGroupSize(1);
        post3.setUser(userB);
        postRepository.save(post3);

        Post post4 = new Post();
        post4.setPrice(2500); // 임의의 값 설정
        post4.setCreatedAt(LocalDateTime.now()); // 현재 시간 설정
        post4.setClosedAt(LocalDateTime.now());
        post4.setTitle("게시물 제목 4");
        post4.setImages("게시물 이미지 4");
        post4.setGroupSize(2);
        post4.setCurGroupSize(1);
        post4.setUser(userB);
        postRepository.save(post4);

        // 게시물 재료 설정
        PostIngredient ingredient1 = new PostIngredient();
        ingredient1.setName("바나나");
        ingredient1.setPost(post1);
        postIngredientRepository.save(ingredient1);

        PostIngredient ingredient2 = new PostIngredient();
        ingredient2.setName("사과");
        ingredient2.setPost(post2);
        postIngredientRepository.save(ingredient2);

        PostIngredient ingredient3 = new PostIngredient();
        ingredient3.setName("딸기");
        ingredient3.setPost(post3);
        postIngredientRepository.save(ingredient3);

        PostIngredient ingredient4 = new PostIngredient();
        ingredient4.setName("키위");
        ingredient4.setPost(post4);
        postIngredientRepository.save(ingredient4);
    }

    private void setUserPostLike(){
        // 사용자 "aaa"가 좋아하는 게시물 설정
        User userA = userRepository.findById("aaa").orElse(null);
        if (userA != null) {
            // 사용자 "aaa"가 좋아하는 게시물과 관련된 정보 설정
            UserLikePost userLikePost1 = new UserLikePost();
            userLikePost1.setUser(userA);
            userLikePost1.setPostId(3); // "aaa"가 작성한 post id가 3인 게시물을 좋아함
            userLikePostRepository.save(userLikePost1);

            UserLikePost userLikePost2 = new UserLikePost();
            userLikePost2.setUser(userA);
            userLikePost2.setPostId(4); // "aaa"가 작성한 post id가 4인 게시물을 좋아함
            userLikePostRepository.save(userLikePost2);
        }

        // 사용자 "bbb"가 좋아하는 게시물 설정
        User userB = userRepository.findById("bbb").orElse(null);
        if (userB != null) {
            // 사용자 "bbb"가 좋아하는 게시물과 관련된 정보 설정
            UserLikePost userLikePost3 = new UserLikePost();
            userLikePost3.setUser(userB);
            userLikePost3.setPostId(1); // "bbb"가 작성한 post id가 1인 게시물을 좋아함
            userLikePostRepository.save(userLikePost3);

            UserLikePost userLikePost4 = new UserLikePost();
            userLikePost4.setUser(userB);
            userLikePost4.setPostId(2); // "bbb"가 작성한 post id가 2인 게시물을 좋아함
            userLikePostRepository.save(userLikePost4);
        }
    }
}
