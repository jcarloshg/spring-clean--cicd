package com.clean_archi.crud_items.auth.dto.response;

import java.time.LocalDateTime;

public record ApiResponse<T>(
    LocalDateTime timestamp,
    int status,
    String message,
    T data
) {
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(LocalDateTime.now(), 200, "Success", data);
    }

    public static <T> ApiResponse<T> error(int status, String message) {
        return new ApiResponse<>(LocalDateTime.now(), status, message, null);
    }
}