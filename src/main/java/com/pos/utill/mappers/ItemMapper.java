package com.pos.utill.mappers;

import com.pos.dto.ItemDTO;
import com.pos.dto.request.RequestSaveItemDTO;
import com.pos.entity.Item;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
Item requsetDtoToEntity(RequestSaveItemDTO requestSaveItemDTO);
List<ItemDTO> entityListToDtoList(List<Item> itemList);

List<ItemDTO> pageToList(Page<Item> items);
}
