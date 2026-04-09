package com.clean_archi.crud_items.auth.controller;

import com.clean_archi.crud_items.auth.dto.UserDto;
import com.clean_archi.crud_items.auth.dto.request.SignupRequest;
import com.clean_archi.crud_items.auth.dto.request.UpdateRequest;
import com.clean_archi.crud_items.auth.dto.response.ApiResponse;
import com.clean_archi.crud_items.auth.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/info")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<UserDto>> signup(@Valid @RequestBody SignupRequest request) {
        UserDto result = authService.signup(request);
        return ResponseEntity.ok(ApiResponse.success(result));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<UserDto>> update(@PathVariable Long id, @Valid @RequestBody UpdateRequest request) {
        UserDto result = authService.update(id, request);
        return ResponseEntity.ok(ApiResponse.success(result));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserDto>> getById(@PathVariable Long id) {
        UserDto result = authService.getById(id);
        return ResponseEntity.ok(ApiResponse.success(result));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        authService.delete(id);
        return ResponseEntity.noContent().build();
    }
}