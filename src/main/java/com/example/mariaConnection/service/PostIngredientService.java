package com.example.mariaConnection.service;

import com.example.mariaConnection.entity.Post;
import com.example.mariaConnection.entity.PostIngredient;

import java.util.List;

public interface PostIngredientService {
    List<PostIngredient> getIngredientsByPost(Post post);
}
