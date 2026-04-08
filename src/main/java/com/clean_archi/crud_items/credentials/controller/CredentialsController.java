package com.clean_archi.crud_items.credentials.controller;

import com.clean_archi.crud_items.credentials.service.CredentialsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/credentials")
public class CredentialsController {

    private final CredentialsService credentialsService;

    public CredentialsController(CredentialsService credentialsService) {
        this.credentialsService = credentialsService;
    }

    @GetMapping("/token-info")
    public ResponseEntity<?> getTokenInfo(
            @RequestHeader("Authorization") String authorization,
            @RequestHeader(value = "X-Request-Id", required = false) String requestId) {
        return ResponseEntity.ok(credentialsService.getTokenInfo(authorization, requestId));
    }

    @GetMapping("/user-agent")
    public ResponseEntity<?> getUserAgent(
            @RequestHeader("User-Agent") String userAgent) {
        return ResponseEntity.ok(credentialsService.getUserAgent(userAgent));
    }

    @GetMapping("/headers")
    public ResponseEntity<?> getAllHeaders(
            @RequestHeader("Accept-Language") String acceptLanguage,
            @RequestHeader(value = "Accept", defaultValue = "application/json") String accept,
            @RequestHeader(value = "X-Custom-Header", required = false) String customHeader) {
        return ResponseEntity.ok(credentialsService.getAllHeaders(acceptLanguage, accept, customHeader));
    }

    @GetMapping("/accepted")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String accepted() {
        return "Request accepted for processing";
    }

    @GetMapping("/no-content")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void noContent() {
    }

    @GetMapping("/created")
    @ResponseStatus(HttpStatus.CREATED)
    public String created() {
        return "Resource created successfully";
    }
}