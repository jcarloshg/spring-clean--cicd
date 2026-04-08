package com.clean_archi.crud_items;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/info")
public class AuthController {

    public record SignupRequest(
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

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@Valid @RequestBody SignupRequest request) {
        return ResponseEntity.ok("User signup: " + request.name());
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@Valid @RequestBody UpdateRequest request) {
        return ResponseEntity.ok("User updated: " + request.name());
    }
}

