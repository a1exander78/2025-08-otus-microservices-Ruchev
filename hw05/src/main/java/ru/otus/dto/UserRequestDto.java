package ru.otus.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UserRequestDto(
        @NotBlank
        @Size(max = 16, message = "Too long")
        String username,
        @NotBlank
        @Size(max = 32, message = "Too long")
        String firstName,
        @NotBlank
        @Size(max = 32, message = "Too long")
        String lastName,
        @Email(message = "Invalid email format")
        String email,
        @NotBlank
        @Pattern(regexp = "^\\+7\\d{10}$",
                message = "Phone must be in format +7XXXXXXXXXX")
        String phone) {
}
