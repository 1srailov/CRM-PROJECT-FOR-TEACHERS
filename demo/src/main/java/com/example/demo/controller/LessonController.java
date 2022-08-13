package com.example.demo.controller;


import com.example.demo.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lesson")
@RequiredArgsConstructor
public class LessonController {

    private final LessonService lessonService;


    @GetMapping("/{id}")
    public ResponseEntity<?> getAllLessonAtThisMonthWithGroupId(@PathVariable Integer id){
        return lessonService.getLessonsFromGroupAtThisMonth(id);
    }


}
