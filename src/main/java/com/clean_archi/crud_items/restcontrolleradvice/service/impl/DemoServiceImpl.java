package com.clean_archi.crud_items.restcontrolleradvice.service.impl;

import com.clean_archi.crud_items.restcontrolleradvice.exception.BusinessException;
import com.clean_archi.crud_items.restcontrolleradvice.exception.ResourceNotFoundException;
import com.clean_archi.crud_items.restcontrolleradvice.service.DemoService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {

    @Override
    public String getById(Long id) {
        if (id > 100) {
            throw new ResourceNotFoundException("Item not found with id: " + id);
        }
        return "Item found: " + id;
    }

    @Override
    public String processItem(String name) {
        if ("INVALID".equals(name)) {
            throw new BusinessException("Item cannot be processed", HttpStatus.UNPROCESSABLE_ENTITY.value());
        }
        return "Processed: " + name;
    }

    @Override
    public void validateItem(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Item name cannot be blank");
        }
    }
}