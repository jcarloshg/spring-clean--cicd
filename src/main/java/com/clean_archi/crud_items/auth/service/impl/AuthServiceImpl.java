package com.clean_archi.crud_items.auth.service.impl;

import com.clean_archi.crud_items.auth.dto.UserDto;
import com.clean_archi.crud_items.auth.dto.request.SignupRequest;
import com.clean_archi.crud_items.auth.dto.request.UpdateRequest;
import com.clean_archi.crud_items.auth.entity.User;
import com.clean_archi.crud_items.auth.exception.DuplicateEmailException;
import com.clean_archi.crud_items.auth.exception.UserNotFoundException;
import com.clean_archi.crud_items.auth.repository.UserRepository;
import com.clean_archi.crud_items.auth.service.AuthService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDto signup(SignupRequest request) {
        if (userRepository.existsByEmail(request.email())) {
            throw new DuplicateEmailException(request.email());
        }

        User user = new User(request.name(), request.email(), request.pass());
        User savedUser = userRepository.save(user);

        return toDto(savedUser);
    }

    @Override
    @Transactional
    public UserDto update(Long id, UpdateRequest request) {
        User user = userRepository.findUserById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        if (!user.getEmail().equals(request.email()) && userRepository.existsByEmail(request.email())) {
            throw new DuplicateEmailException(request.email());
        }

        user.setName(request.name());
        user.setEmail(request.email());
        user.setPass(request.pass());

        User updatedUser = userRepository.save(user);

        return toDto(updatedUser);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDto getById(Long id) {
        User user = userRepository.findUserById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        return toDto(user);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
    }

    private UserDto toDto(User user) {
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCreatedAt()
        );
    }
}