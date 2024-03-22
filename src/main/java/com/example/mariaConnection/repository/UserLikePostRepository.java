package com.example.mariaConnection.repository;

import com.example.mariaConnection.entity.User;
import com.example.mariaConnection.entity.UserLikePost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserLikePostRepository extends JpaRepository<UserLikePost, Integer> {
    List<UserLikePost> findByUser(User user);
}
