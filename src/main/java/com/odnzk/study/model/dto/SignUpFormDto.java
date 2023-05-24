package com.odnzk.study.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpFormDto {
    @NotNull
    @NotBlank
    private String username;
    @NotNull
    @Email
    private String email;
    @NotNull
    @NotBlank
    @Length(min = 2, max = 8)
    private String password;
}
