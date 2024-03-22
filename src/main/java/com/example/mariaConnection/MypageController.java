package com.example.mariaConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/mypage")
public class MypageController {


    @Autowired
    private MypageDataLoader mypageDataLoader;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserLikePostRepository userLikePostRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostIngredientRepository postIngredientRepository;


    @GetMapping("/{user_id}")
    public ResponseEntity<Map<String, Object>> getUserData(@PathVariable("user_id") String userId) {
        // 데이터 로드
        mypageDataLoader.loadData();

        // 사용자 데이터 가져오기
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        Map<String, Object> userData = new HashMap<>();
        userData.put("userId", user.getId());
        userData.put("nickname", user.getNickname());
        userData.put("rating", user.getRating());
        userData.put("profile", user.getProfile());

        // 사용자가 좋아하는 게시물 정보 가져오기
        UserLikePost userLikePost = userLikePostRepository.findByUser(user);
        if (userLikePost != null) {
            userData.put("userLikePostId", userLikePost.getId());
            userData.put("postId", userLikePost.getPostId());
        }

        // 게시물 정보 가져오기
        Post post = postRepository.findByUser(user);
        if (post != null) {
            userData.put("price", post.getPrice());
            userData.put("createdAt", post.getCreatedAt());
            userData.put("closedAt", post.getClosedAt());
            userData.put("title", post.getTitle());
            userData.put("images", post.getImages());
            userData.put("groupSize", post.getGroupSize());
        }

        // 게시물 재료 정보 가져오기
        List<PostIngredient> postIngredients = postIngredientRepository.findByPost(post);
        if (!postIngredients.isEmpty()) {
            userData.put("ingredientName", postIngredients.get(0).getName());
        }

        return ResponseEntity.ok(userData);
    }
}