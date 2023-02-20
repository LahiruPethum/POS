package com.pos.dto.paginated;

import com.pos.dto.response.ResponseOrderDetailsDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PginatedResponseOrderDetailsDTO {
    private List<ResponseOrderDetailsDTO> list;
    private long dataCount;
}
