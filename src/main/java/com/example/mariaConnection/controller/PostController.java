package com.example.mariaConnection.controller;

import com.example.mariaConnection.dto.PostDto;
import com.example.mariaConnection.dto.PostIngredientDto;
import com.example.mariaConnection.dto.UserDto;
import com.example.mariaConnection.entity.Post;
import com.example.mariaConnection.entity.PostIngredient;
import com.example.mariaConnection.entity.User;
import com.example.mariaConnection.service.PostService;
import com.example.mariaConnection.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<String> createPost(@RequestBody PostDto postDto) {
        // 사용자 정보 가져오기
        UserDto userDto = postDto.getUser();
        // 사용자 정보를 이용하여 User 엔티티 조회 또는 생성
        User user = userService.getUserById(userDto.getId());
        if (user == null) {
            // 사용자가 없으면 새로 생성
            user = new User();
            user.setId(userDto.getId());
            user.setNickname(userDto.getNickname());
            user.setRating(userDto.getRating());
            user.setProfile(userDto.getProfile());
            userService.saveUser(user);
        }

        // 게시물 정보 설정
        Post post = new Post();
        post.setUser(user);
        post.setTitle(postDto.getTitle());
        post.setPrice(postDto.getPrice());
        post.setImages(postDto.getImages());
        post.setContents(postDto.getContents());
        post.setGroupSize(postDto.getGroupSize());
        post.setCurGroupSize(postDto.getCurGroupSize());
        post.setClosedAt(postDto.getClosedAt());

        // 포스트 재료 설정
        List<PostIngredientDto> ingredientDtos = postDto.getPostIngredients();
        List<PostIngredient> postIngredients = new ArrayList<>();
        for (PostIngredientDto dto : ingredientDtos) {
            PostIngredient ingredient = new PostIngredient();
            ingredient.setName(dto.getName());
            ingredient.setUrl(dto.getUrl());
            ingredient.setPost(post);
            postIngredients.add(ingredient);
        }
        post.setPostIngredients(postIngredients);

        // 게시물 저장
        postService.savePost(post);

        return ResponseEntity.ok("게시물이 성공적으로 생성되었습니다.");
    }
}
