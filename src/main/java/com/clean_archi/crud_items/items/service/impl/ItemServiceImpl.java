package com.clean_archi.crud_items.items.service.impl;

import com.clean_archi.crud_items.items.dto.request.ItemRequest;
import com.clean_archi.crud_items.items.service.ItemService;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    @Override
    public Object getAll(String name, int page, int size) {
        return "Fetching items - name: " + name + ", page: " + page + ", size: " + size;
    }

    @Override
    public Object getById(Long id) {
        return "Item found with id: " + id;
    }

    @Override
    public Object create(ItemRequest request) {
        return "Item created: " + request.name();
    }

    @Override
    public Object update(Long id, ItemRequest request) {
        return "Item " + id + " updated: " + request.name();
    }

    @Override
    public Object delete(Long id, boolean permanent) {
        return "Item " + id + " deleted (permanent=" + permanent + ")";
    }
}