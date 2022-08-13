package com.example.demo.repository;

import com.example.demo.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Integer> {

    @Query("SELECT a from Lesson a where a.groupId = :groupId and a.month = (select max(b.month) from Lesson b)")
    List<Lesson> getAllLessonsAtThisMonthFromGroup(Integer groupId);


    @Query("SELECT Max(a.month) from Lesson a where a.id = max(a.id) and a.groupId = :groupId")
    Integer getMonthWithGroupId(Integer groupId);

}