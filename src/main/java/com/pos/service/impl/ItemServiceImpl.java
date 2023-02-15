package com.pos.service.impl;

import com.pos.dto.ItemDTO;
import com.pos.dto.request.RequestSaveItemDTO;
import com.pos.entity.Item;
import com.pos.repo.ItemRepo;
import com.pos.service.ItemService;
import com.pos.utill.mappers.ItemMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

  @Autowired
  private ItemRepo itemRepo;

  @Autowired
  private ModelMapper modelMapper;

  @Autowired
  private ItemMapper itemMapper;



    @Override
    public String addItem(RequestSaveItemDTO requestSaveItemDTO) {

        Item item=itemMapper.requsetDtoToEntity(requestSaveItemDTO);
        item.setActiveState(false);

        if (!itemRepo.existsById(item.getItemId())){
            itemRepo.save(item);
            return "item saved";
        }else {
            return "Item is already here";
        }
    }

    @Override
    public ItemDTO getCustomerById(int itemId) {
        Item item= itemRepo.getById(itemId);

        if (item!=null){
            ItemDTO itemDTO = new ItemDTO(

            );
            return itemDTO;
        }else {
            return null;
        }
    }

    @Override
//    public List<ItemDTO> getAllItems() {
//        List<Item> getAllItems = itemRepo.findAll();
//        List<ItemDTO> itemDTOList = new ArrayList<>();
//
//        if (getAllItems!=null){
//            for (Item item : getAllItems){
//                ItemDTO itemDTO = new ItemDTO(
//                        item.getItemId(),
//                        item.getItemName(),
//                        item.getSellingPrice(),
//                        item.isActiveState()
//                );
//
//                itemDTOList.add(itemDTO);
//            }
//            return itemDTOList;
//        }else {
//            return null;
//        }
//
//    }
    public List<ItemDTO> getAllItems() {
        List<Item> getAllItems = itemRepo.findAll();
        List<ItemDTO> itemDTOList = new ArrayList<>();

        if (getAllItems!=null){
            itemDTOList=modelMapper.map(getAllItems, new TypeToken<List
                    <ItemDTO>>(){}.getType());
            return itemDTOList;
        }else {
            return null;
        }

    }

    @Override
    public String deleteItem(int itemId) {
        if (itemRepo.existsById(itemId)){
            itemRepo.deleteById(itemId);
            return "deleted item";
        }else {
            System.out.println("no item to delete");
        }
        return "no item to delete";
    }

    @Override

    public String updateItem(ItemDTO itemDTO) {
        if (itemRepo.existsById(itemDTO.getItemId())) {
            Item item = itemRepo.getById(itemDTO.getItemId());

            item.setItemName(itemDTO.getItemName());
            item.setSellingPrice(itemDTO.getSellingPrice());


            itemRepo.save(item);
            return "updated";

        }else {
            System.out.println("no item to update");
        }
        return "no item to update";
    }


}
