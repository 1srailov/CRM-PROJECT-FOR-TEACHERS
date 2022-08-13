package com.example.demo.dtos.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentTaskRequest {

    private Integer taskId;

    private Integer studentId;

    private Integer ball;

    private Integer description;

}
