package com.pos.service.impl;

import com.pos.dto.ItemDTO;
import com.pos.entity.Item;
import com.pos.repo.ItemRepo;
import com.pos.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

  @Autowired
  private ItemRepo itemRepo;
    @Override
    public String addItem(ItemDTO itemDTO) {
        Item item = new Item(
                itemDTO.getItemId(),
                itemDTO.getItemName(),
                itemDTO.getSellingPrice(),
                itemDTO.isActiveState()

        );

        if (!itemRepo.existsById(itemDTO.getItemId())){
            itemRepo.save(item);
            return "item saved";
        }else {
            return "Item is already here";
        }
    }
}
