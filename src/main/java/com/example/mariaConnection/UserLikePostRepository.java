package com.example.mariaConnection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserLikePostRepository extends JpaRepository<UserLikePost, Integer> {
    UserLikePost findByUser(User user);
}
