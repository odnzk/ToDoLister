package com.odnzk.study.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ResetPasswordDto(
        @NotBlank
        @NotNull
        String username) {
}
