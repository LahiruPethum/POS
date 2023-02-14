package com.pos.service;

import com.pos.dto.ItemDTO;

import java.util.List;

public interface ItemService {
     String updateItem(ItemDTO itemDTO);

    String addItem(ItemDTO itemDTO);

    ItemDTO getCustomerById(int itemId);

    List<ItemDTO> getAllItems();

    String deleteItem(int itemId);
}
