package com.clean_archi.crud_items.auth.service;

import com.clean_archi.crud_items.auth.dto.request.SignupRequest;
import com.clean_archi.crud_items.auth.dto.request.UpdateRequest;

public interface AuthService {
    String signup(SignupRequest request);
    String update(UpdateRequest request);
    String getById(Long id);
    String delete(Long id);
}