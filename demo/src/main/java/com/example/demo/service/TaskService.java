package com.example.demo.service;

import com.example.demo.dtos.request.FinishTaskRequest;
import com.example.demo.dtos.request.StartTaskRequest;
import com.example.demo.dtos.response.MessageResponse;
import org.springframework.http.ResponseEntity;

public interface TaskService {

    ResponseEntity<MessageResponse> addNewTaskFromGroup(StartTaskRequest taskResponse);

    ResponseEntity<MessageResponse> finishTask(FinishTaskRequest finishTaskRequest);

}
