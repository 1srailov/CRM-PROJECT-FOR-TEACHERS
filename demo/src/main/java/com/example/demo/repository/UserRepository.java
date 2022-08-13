package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT a.id from User a where a.username = :username")
    Integer getUserIdByUsername(String username);
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);
}
