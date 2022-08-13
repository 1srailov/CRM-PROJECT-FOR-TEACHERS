package com.example.demo.service;

import com.example.demo.dtos.response.GroupResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GroupService {

    ResponseEntity<List<GroupResponse>> getGroupsFromUser(String jwt);
}
