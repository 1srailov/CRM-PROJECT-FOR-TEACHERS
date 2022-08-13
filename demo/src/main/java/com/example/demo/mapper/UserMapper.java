package com.example.demo.mapper;


import com.example.demo.dtos.request.SignupRequest;
import com.example.demo.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper{

    User toEntity(SignupRequest signupRequest);
}
