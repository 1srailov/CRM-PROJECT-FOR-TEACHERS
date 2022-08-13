package com.example.demo.service.impl;

import com.example.demo.dtos.request.LessonRequest;
import com.example.demo.dtos.response.LessonResponse;
import com.example.demo.dtos.response.MessageResponse;
import com.example.demo.entity.Lesson;
import com.example.demo.entity.Student;
import com.example.demo.mapper.LessonMapper;
import com.example.demo.repository.LessonRepository;

import com.example.demo.service.LessonService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Set;


@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;

    private final LessonMapper lessonMapper;

    private final StudentServiceImpl studentService;

    @Override
    public ResponseEntity<List<LessonResponse>> getLessonsFromGroupAtThisMonth(Integer groupId){

        List<Lesson> lessons = lessonRepository.getAllLessonsAtThisMonthFromGroup(groupId);

        List<LessonResponse> lessonResponses = lessonMapper.toResponses(lessons);

        return ResponseEntity.ok().body(lessonResponses);
    }

    @Override
    public ResponseEntity<MessageResponse> addLessonFromGroup(LessonRequest lessonRequest){
        List<Student> students = studentService.getAllStudentByIds(lessonRequest.getStudentIds());

        lessonRepository.save(Lesson.builder()
                        .name(lessonRequest.getName())
                        .date(new Date(System.currentTimeMillis()))
                        .groupId(lessonRequest.getGroupId())
                        .students(students)
                        .month(lessonRepository.getMonthWithGroupId(lessonRequest.getGroupId()))
                .build());

        return ResponseEntity.ok(new MessageResponse("LESSON ADDED SUCCESSFULLY"));

    }

    @Override
    public ResponseEntity<MessageResponse> finishMonthFromGroup(Integer groupId) {
        return null;
    }
}
