package com.pos.controller;

import com.pos.dto.ItemDTO;
import com.pos.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
