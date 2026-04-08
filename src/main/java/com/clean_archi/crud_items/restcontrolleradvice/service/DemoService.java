package com.clean_archi.crud_items.restcontrolleradvice.service;

public interface DemoService {
    String getById(Long id);
    String processItem(String name);
    void validateItem(String name);
}