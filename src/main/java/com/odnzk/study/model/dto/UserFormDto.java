package com.odnzk.study.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserFormDto {
    private Long id;
    @NotNull
    @Email
    private String email;
    @NotNull
    private String username;
    @NotNull
    private String password;
}
