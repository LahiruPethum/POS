package com.pos.service;

import com.pos.dto.request.RequestOrederSaveDto;

public interface OrderService {
    String addOrder(RequestOrederSaveDto requestOrederSaveDto);

}
