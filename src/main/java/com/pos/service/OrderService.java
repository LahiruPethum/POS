package com.pos.service;

import com.pos.dto.paginated.PginatedResponseOrderDetailsDTO;
import com.pos.dto.request.RequestOrederSaveDto;

public interface OrderService {
    String addOrder(RequestOrederSaveDto requestOrederSaveDto);

    PginatedResponseOrderDetailsDTO getAllOderDetails(boolean status, int page, int size);
}
