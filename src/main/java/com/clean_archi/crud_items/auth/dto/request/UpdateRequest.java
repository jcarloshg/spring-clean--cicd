package com.clean_archi.crud_items.auth.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UpdateRequest(
    @Size(min = 4, max = 30, message = "Name must be between 4 and 30 characters")
    String name,

    @Size(min = 4, message = "Email must be at least 4 characters")
    @Email(message = "Invalid email format")
    String email,

    @Size(min = 4, message = "Password must be at least 4 characters")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?]).{4,}$",
            message = "Password must contain at least one letter, one digit, and one special character")
    String pass
) {}