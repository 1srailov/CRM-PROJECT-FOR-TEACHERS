package com.example.demo.service.impl;

import com.example.demo.dtos.response.GroupResponse;
import com.example.demo.entity.Group;
import com.example.demo.mapper.GroupMapper;
import com.example.demo.repository.GroupRepository;
import com.example.demo.service.GroupService;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class GroupServiceImpl implements GroupService {

    private final UserService userService;

    private final GroupRepository groupRepository;

    private final GroupMapper groupMapper;

    @Override
    public ResponseEntity<List<GroupResponse>> getGroupsFromUser(String jwt){
        Integer userId = userService.getIdFromJwt(jwt);

        List<Group> groups = groupRepository.findAllByUserId(userId);

        List<GroupResponse> groupResponses = groupMapper.toResponses(groups);

        return ResponseEntity.ok().body(groupResponses);

    }

}
