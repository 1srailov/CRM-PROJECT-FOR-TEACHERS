package com.example.demo.service;

import com.example.demo.dtos.response.StudentResponse;
import org.springframework.http.ResponseEntity;

public interface StudentService{

    ResponseEntity<StudentResponse> getAllStudentsFromGroup(Integer groupId);


}
