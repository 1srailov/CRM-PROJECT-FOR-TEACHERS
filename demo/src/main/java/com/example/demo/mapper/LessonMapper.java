package com.example.demo.mapper;

import com.example.demo.dtos.response.LessonResponse;
import com.example.demo.entity.Lesson;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LessonMapper {

    List<LessonResponse> toResponses(List<Lesson> lessons);

}
