package com.example.demo.service.impl;

import com.example.demo.dtos.request.LoginRequest;
import com.example.demo.dtos.request.SignupRequest;
import com.example.demo.dtos.response.JwtResponse;
import com.example.demo.dtos.response.MessageResponse;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.jwt.JwtUtils;
import com.example.demo.security.services.UserDetailsImpl;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    private final AuthenticationManager authenticationManager;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtUtils jwtUtils;

    private final UserMapper userMapper;


    public ResponseEntity<?> login(LoginRequest loginRequest){
        try {
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                    loginRequest.getPassword(), new ArrayList<>());

            authenticationManager.authenticate(authentication);

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtUtils.generateJwtToken(authentication);

            UserDetailsImpl userDetails = UserDetailsImpl.build
                    (userRepository.findByUsername(authentication.getPrincipal().toString()).get());

            List<String> roles = userDetails.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority).collect(Collectors.toList());

            return ResponseEntity.ok(new JwtResponse(
                    jwt, userDetails.getId(), userDetails.getUsername(), roles
            ));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(403).body("valid username or password");
        }
    }


    public ResponseEntity<?> signup(SignupRequest signUpRequest){
        if(!userRepository.existsByUsername(signUpRequest.getUsername())){
            userRepository.save(setUserWithDetails(signUpRequest));
            return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
        }
        return ResponseEntity.status(403).body("valid username");
    }

    @Override
    public Integer getIdFromJwt(String jwt){

        Integer userId = userRepository.getUserIdByUsername(jwtUtils.getUserNameFromJwtToken(jwt));

        return userId;

    }


    private User setUserWithDetails(SignupRequest signupRequest){
        User user = userMapper.toEntity(signupRequest);
        user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        HashSet<Role> roles = new HashSet();
        roles.add(new Role(
                signupRequest.getRoleCode() == 1 ? 1 : 2
        ));
        return user;
    }
}

