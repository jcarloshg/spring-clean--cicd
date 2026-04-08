package com.clean_archi.crud_items.auth.dto.response;

import java.time.LocalDateTime;
import java.util.List;

public record ValidationErrorResponse(
    LocalDateTime timestamp,
    int status,
    String error,
    List<FieldError> fieldErrors
) {
    public record FieldError(
        String field,
        String message
    ) {}
}