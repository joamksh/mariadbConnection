package com.example.mariaConnection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostIngredientRepository extends JpaRepository<PostIngredient, Integer> {
    List<PostIngredient> findByPost(Post post);
}
