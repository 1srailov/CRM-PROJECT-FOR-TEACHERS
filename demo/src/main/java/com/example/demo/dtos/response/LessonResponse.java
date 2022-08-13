package com.example.demo.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LessonResponse {

    private Integer id;

    private Integer name;

    private Integer studentsCount;

    private Date date;




}
