package com.pos.service;

import com.pos.dto.ItemDTO;
import com.pos.dto.paginated.PaginatedResponseItemDto;
import com.pos.dto.request.RequestSaveItemDTO;
import com.pos.exception.NotFoundExcption;

import java.util.List;

public interface ItemService {
    String updateItem(ItemDTO itemDTO);

    String addItem(RequestSaveItemDTO itemDTO);

    List<ItemDTO> getAllItems();

    String deleteItem(int itemId);

    List<ItemDTO> getItemByName(String itemName);


    PaginatedResponseItemDto getAllActiveItems(int page, int size, boolean activeState);
}
