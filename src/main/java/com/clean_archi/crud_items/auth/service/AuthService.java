package com.clean_archi.crud_items.auth.service;

import com.clean_archi.crud_items.auth.dto.UserDto;
import com.clean_archi.crud_items.auth.dto.request.SignupRequest;
import com.clean_archi.crud_items.auth.dto.request.UpdateRequest;

public interface AuthService {
    UserDto signup(SignupRequest request);
    UserDto update(Long id, UpdateRequest request);
    UserDto getById(Long id);
    void delete(Long id);
}