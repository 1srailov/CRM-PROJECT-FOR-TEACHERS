package com.example.demo.service.impl;

import com.example.demo.dtos.request.FinishTaskRequest;
import com.example.demo.dtos.request.StartTaskRequest;
import com.example.demo.dtos.response.MessageResponse;
import com.example.demo.service.TaskService;
import org.springframework.http.ResponseEntity;

public class TaskServiceImpl implements TaskService {
    @Override
    public ResponseEntity<MessageResponse> addNewTaskFromGroup(StartTaskRequest taskResponse) {
        return null;
    }

    @Override
    public ResponseEntity<MessageResponse> finishTask(FinishTaskRequest finishTaskRequest) {
        return null;
    }
}
