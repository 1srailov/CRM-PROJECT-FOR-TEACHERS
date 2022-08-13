package com.example.demo.service.impl;

import com.example.demo.dtos.response.StudentResponse;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public ResponseEntity<StudentResponse> getAllStudentsFromGroup(Integer groupId) {
        return null;
    }

    public List<Student> getAllStudentByIds(Set<Integer> ids){
       return studentRepository.findAllById(ids);
    }
}
