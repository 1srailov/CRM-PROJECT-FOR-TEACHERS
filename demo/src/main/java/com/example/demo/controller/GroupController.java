package com.example.demo.controller;

import com.example.demo.dtos.response.GroupResponse;
import com.example.demo.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/group")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    @GetMapping
    public ResponseEntity<List<GroupResponse>> getCoursesFromUser(HttpServletRequest request){
        String jwt = request.getHeader("Authorization").substring(7);
        return groupService.getGroupsFromUser(jwt);
    }
}
