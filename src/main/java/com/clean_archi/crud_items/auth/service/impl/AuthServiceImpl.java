package com.clean_archi.crud_items.auth.service.impl;

import com.clean_archi.crud_items.auth.dto.request.SignupRequest;
import com.clean_archi.crud_items.auth.dto.request.UpdateRequest;
import com.clean_archi.crud_items.auth.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public String signup(SignupRequest request) {
        return "User signup: " + request.name();
    }

    @Override
    public String update(UpdateRequest request) {
        return "User updated: " + request.name();
    }
}