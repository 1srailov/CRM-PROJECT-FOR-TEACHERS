package com.example.demo.security.jwt;

import com.example.demo.repository.UserRepository;
import com.example.demo.security.services.UserDetailsImpl;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import java.util.Date;

@Slf4j
@Component

public class JwtUtils {
    @Value("${demo.jwtSecret}")
    private String jwtSecret;

    @Value("${demo.jwtExpirationMs}")
    private String jwtExpirationMs;

    @Autowired
    private UserRepository userRepository;

    public String generateJwtToken(Authentication authentication){
        UserDetailsImpl userDetails = UserDetailsImpl.build(
                userRepository.findByUsername(authentication.getPrincipal().toString()).get()
        );

        return Jwts.builder().setSubject((userDetails.getUsername())).setIssuedAt(new Date())
                .setExpiration(new Date(Long.parseLong(jwtExpirationMs) + new Date().getTime()))
                .signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
    }

    public String getUserNameFromJwtToken(String token){
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }


    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }




}
