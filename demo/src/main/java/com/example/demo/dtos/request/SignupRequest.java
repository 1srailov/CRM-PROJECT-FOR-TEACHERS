package com.example.demo.dtos.request;

import com.example.demo.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequest {

        @NotBlank
        @NotNull
        @Size(min = 3, max = 20)
        private String firstName;

        @NotBlank
        @NotNull
        @Size(min = 3, max = 20)
        private String lastName;

        @NotBlank
        @NotNull
        @Size(min = 3, max = 20)
        private String telegramUsername;

        @NotBlank
        @NotNull
        @Size(min = 3, max = 20)
        private String username;

        @NotBlank
        @NotNull
        @Size(min = 3, max = 20)
        private String password;

        @NotBlank
        @NotNull
        @Size(min = 3, max = 20)
        private Integer roleCode;

}
