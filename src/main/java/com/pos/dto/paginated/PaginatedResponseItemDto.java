package com.pos.dto.paginated;

import com.pos.dto.ItemDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedResponseItemDto {
    private List<ItemDTO> itemDTOList ;
    private long dataCount;
}
