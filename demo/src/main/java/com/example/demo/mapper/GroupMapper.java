package com.example.demo.mapper;

import com.example.demo.dtos.response.GroupResponse;
import com.example.demo.entity.Group;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GroupMapper{

    List<GroupResponse> toResponses(List<Group> groups);
}
