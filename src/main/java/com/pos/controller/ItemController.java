package com.pos.controller;

import com.pos.dto.CustomerDTO;
import com.pos.dto.ItemDTO;
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
    public String saveItem(@RequestBody ItemDTO itemDTO){
        String s = itemService.addItem(itemDTO);
        return s;
    }

    @GetMapping(path="/get-by-id",
            params = "id")
    public ItemDTO getItemById(@RequestParam(value = "id") int itemId){
        ItemDTO itemDTO = itemService.getCustomerById(itemId);
        return itemDTO;
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
