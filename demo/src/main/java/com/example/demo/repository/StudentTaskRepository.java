package com.example.demo.repository;

import com.example.demo.entity.StudentTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentTaskRepository extends JpaRepository<StudentTask, Integer> {
}