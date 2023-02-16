package com.pos.controller;

import com.pos.dto.CustomerDTO;
import com.pos.dto.ItemDTO;
import com.pos.dto.paginated.PaginatedResponseItemDto;
import com.pos.dto.request.RequestSaveItemDTO;
import com.pos.exception.NotFoundExcption;
import com.pos.service.ItemService;
import com.pos.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
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
//    public List<ItemDTO> getAllItems(){
//        List<ItemDTO> allItems = itemService.getAllItems();
//        return allItems;
//    }

//    public ResponseEntity<StandardResponse> getallItems(){
//        List<ItemDTO> itemDTOList = itemService.getAllItems();
//        ResponseEntity<StandardResponse> m = new ResponseEntity<StandardResponse>(
//                new StandardResponse(200,"Success",itemDTOList), HttpStatus.OK
//        );
//        return m;
//    }

    public ResponseEntity<StandardResponse> getallItems() {
        List<ItemDTO> itemDTOList =itemService.getAllItems();

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success",itemDTOList),
                HttpStatus.OK
        );
    }

    @GetMapping(path = "/get-all-active",
    params = {"page","size","activeState"})
    public ResponseEntity<StandardResponse> getallItems(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size")@Max(10) int size,
            @RequestParam(value = "activeState") boolean activeState){
        PaginatedResponseItemDto paginatedResponseItemDto =itemService.getAllActiveItems(page,size,activeState);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success",paginatedResponseItemDto),
                HttpStatus.OK
        );
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
