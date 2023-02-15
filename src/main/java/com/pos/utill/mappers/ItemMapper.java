package com.pos.utill.mappers;

import com.pos.dto.request.RequestSaveItemDTO;
import com.pos.entity.Item;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemMapper {
Item requsetDtoToEntity(RequestSaveItemDTO requestSaveItemDTO);
}
