package com.example.demo.repository;

import com.example.demo.entity.CourseType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseTypeRepository extends JpaRepository<CourseType, Integer> {
}