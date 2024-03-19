package com.example.mariaConnection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.mariaConnection.Test;
import java.util.Optional;

@Repository
public interface TestRepository extends JpaRepository<Test, Integer> {
    Optional<Test> findById(Integer id);
}
