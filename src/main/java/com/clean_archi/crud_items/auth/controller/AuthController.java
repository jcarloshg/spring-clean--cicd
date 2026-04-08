package com.clean_archi.crud_items.auth.controller;

import com.clean_archi.crud_items.auth.dto.request.SignupRequest;
import com.clean_archi.crud_items.auth.dto.request.UpdateRequest;
import com.clean_archi.crud_items.auth.dto.response.ApiResponse;
import com.clean_archi.crud_items.auth.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/info")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<String>> signup(@Valid @RequestBody SignupRequest request) {
        String result = authService.signup(request);
        return ResponseEntity.ok(ApiResponse.success(result));
    }

    @PutMapping("/update")
    public ResponseEntity<ApiResponse<String>> update(@Valid @RequestBody UpdateRequest request) {
        String result = authService.update(request);
        return ResponseEntity.ok(ApiResponse.success(result));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> getById(@PathVariable Long id) {
        String result = authService.getById(id);
        return ResponseEntity.ok(ApiResponse.success(result));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> delete(@PathVariable Long id) {
        String result = authService.delete(id);
        return ResponseEntity.ok(ApiResponse.success(result));
    }
}