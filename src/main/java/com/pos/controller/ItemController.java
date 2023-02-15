package com.pos.controller;

import com.pos.dto.CustomerDTO;
import com.pos.dto.ItemDTO;
import com.pos.dto.request.RequestSaveItemDTO;
import com.pos.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping(path = "/save")
    public String saveItem(@RequestBody RequestSaveItemDTO requestSaveItemDTO){
        String s = itemService.addItem(requestSaveItemDTO);
        return s;
    }

    @GetMapping(path="/get-by-name",
            params = "name")
    public List<ItemDTO> getItemByName(@RequestParam(value = "name") String itemName){
        List<ItemDTO> itemDTOList = itemService.getItemByName(itemName);
        return itemDTOList;
    }

    @GetMapping(path = "/get-all")
    public List<ItemDTO> getAllItems(){
        List<ItemDTO> allItems = itemService.getAllItems();
        return allItems;
    }

    @PutMapping(path = "/update")
    public String updateItem(@RequestBody ItemDTO itemDTO){
        String s = itemService.updateItem(itemDTO);
        return s;
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteItem(@PathVariable(value = "id")int itemId){
        String deleted = itemService.deleteItem(itemId);
        return deleted;
    }
}