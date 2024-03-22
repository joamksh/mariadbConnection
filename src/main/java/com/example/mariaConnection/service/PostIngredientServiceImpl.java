package com.example.mariaConnection.service;

import com.example.mariaConnection.entity.Post;
import com.example.mariaConnection.entity.PostIngredient;
import com.example.mariaConnection.repository.PostIngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PostIngredientServiceImpl implements PostIngredientService {

    @Autowired
    private PostIngredientRepository postIngredientRepository;

    @Override
    public List<PostIngredient> getIngredientsByPost(Post post) {
        return postIngredientRepository.findByPost(post);
    }
}
