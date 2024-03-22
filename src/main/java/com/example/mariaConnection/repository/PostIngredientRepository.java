package com.example.mariaConnection.repository;

import com.example.mariaConnection.entity.Post;
import com.example.mariaConnection.entity.PostIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostIngredientRepository extends JpaRepository<PostIngredient, Integer> {
    List<PostIngredient> findByPost(Post post);
}
