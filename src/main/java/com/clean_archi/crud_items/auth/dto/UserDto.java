package com.clean_archi.crud_items.auth.dto;

import java.time.LocalDateTime;

public record UserDto(
    Long id,
    String name,
    String email,
    LocalDateTime createdAt
) {}