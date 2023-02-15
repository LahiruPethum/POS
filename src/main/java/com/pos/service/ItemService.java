package com.pos.service;

import com.pos.dto.ItemDTO;
import com.pos.dto.request.RequestSaveItemDTO;

import java.util.List;

public interface ItemService {
    String updateItem(ItemDTO itemDTO);

    String addItem(RequestSaveItemDTO itemDTO);

    List<ItemDTO> getAllItems();

    String deleteItem(int itemId);

    List<ItemDTO> getItemByName(String itemName);
}
