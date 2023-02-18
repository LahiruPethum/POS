package com.pos.controller;

import com.pos.dto.request.RequestOrederSaveDto;
import com.pos.service.OrderService;
import com.pos.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/order")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> saveItem(@RequestBody RequestOrederSaveDto requestOrederSaveDto){

//        System.out.println(requestOrederSaveDto);
       String s = orderService.addOrder(requestOrederSaveDto);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,2+"item successfully saved", 2),
                HttpStatus.CREATED
        );
    }
}
