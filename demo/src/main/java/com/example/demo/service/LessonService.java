package com.example.demo.service;

import com.example.demo.dtos.request.LessonRequest;
import com.example.demo.dtos.response.LessonResponse;
import com.example.demo.dtos.response.MessageResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

public interface LessonService {

    ResponseEntity<List<LessonResponse>> getLessonsFromGroupAtThisMonth(Integer groupId);

    ResponseEntity<MessageResponse> addLessonFromGroup(LessonRequest lessonRequest);

    ResponseEntity<MessageResponse> finishMonthFromGroup(Integer groupId);

}
