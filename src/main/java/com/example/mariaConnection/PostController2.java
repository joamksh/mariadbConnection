//package com.example.mariaConnection;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/post")
//public class PostController2 {
//
//    @Autowired
//    private PostRepository postRepository;
//
//    @GetMapping("/posts")
//    public ResponseEntity<List<Map<String, Object>>> getPostsWithIngredients() {
//        List<Post> posts = postRepository.findAll();
//        List<Map<String, Object>> data = new ArrayList<>();
//        for (Post post : posts) {
//            Map<String, Object> postData = new HashMap<>();
//            postData.put("postid", post.getId());
//            postData.put("posttitle", post.getTitle());
//            postData.put("postprice", post.getPrice());
//            postData.put("created_at", post.getCreatedAt());
//            postData.put("postImages", post.getImages());
//            postData.put("postContents", post.getContents());
//            postData.put("postGroupSize", post.getGroupSize());
//            postData.put("postCurGroupSize", post.getCurGroupSize());
//            postData.put("closedAt", post.getClosedAt());
//
//            List<Map<String, Object>> ingredientData = new ArrayList<>();
//            for (PostIngredient ingredient : post.getPostIngredients()) {
//                Map<String, Object> ingredientMap = new HashMap<>();
//                ingredientMap.put("ingreid", ingredient.getId());
//                ingredientMap.put("ingrename", ingredient.getName());
//                ingredientMap.put("ingreurl", ingredient.getUrl());
//                ingredientData.add(ingredientMap);
//            }
//            postData.put("ingredients", ingredientData);
//
//            User user = post.getUser();
//            Map<String, Object> userData = new HashMap<>();
//            userData.put("userid", user.getId());
//            userData.put("usernickname", user.getNickname());
//            userData.put("userrating", user.getRating());
//            userData.put("userprofile", user.getProfile());
//            postData.put("user", userData);
//
//            data.add(postData);
//        }
//
//        return ResponseEntity.ok(data);
//    }
//}
