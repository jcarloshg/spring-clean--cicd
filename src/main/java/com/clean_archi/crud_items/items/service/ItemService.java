package com.clean_archi.crud_items.items.service;

import com.clean_archi.crud_items.items.dto.request.ItemRequest;

public interface ItemService {
    Object getAll(String name, int page, int size);
    Object getById(Long id);
    Object create(ItemRequest request);
    Object update(Long id, ItemRequest request);
    Object delete(Long id, boolean permanent);
}