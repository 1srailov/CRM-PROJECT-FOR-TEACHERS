package com.example.demo.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LessonRequest {

    private String name;

    private Integer groupId;

    private Set<Integer> studentIds;
}
