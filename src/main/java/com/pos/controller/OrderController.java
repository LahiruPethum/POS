package com.pos.controller;

import com.pos.dto.paginated.PginatedResponseOrderDetailsDTO;
import com.pos.dto.request.RequestOrederSaveDto;
import com.pos.service.OrderService;
import com.pos.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;

@RestController
@RequestMapping("api/v1/order")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> saveItem(@RequestBody RequestOrederSaveDto requestOrederSaveDto) {

//        System.out.println(requestOrederSaveDto);
        String s = orderService.addOrder(requestOrederSaveDto);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, s + "item successfully saved", s),
                HttpStatus.CREATED
        );
    }

    @GetMapping(path = "/get-order-details",
            params = {"stateType", "page", "size"})
    public ResponseEntity<StandardResponse> getAllOrderDetails(
            @RequestParam(value = "stateType") String stateType,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") @Max(50) int size
    ) {
        PginatedResponseOrderDetailsDTO pginatedResponseOrderDetails = null;

        if (stateType.equalsIgnoreCase("active") | stateType.equalsIgnoreCase("inactive")) {
            boolean status = stateType.equalsIgnoreCase("active") ? true : false;
            pginatedResponseOrderDetails = orderService.getAllOderDetails(status, page, size);
        }

            return new ResponseEntity<StandardResponse>(
                    new StandardResponse(200, "success", pginatedResponseOrderDetails),
                    HttpStatus.OK
            );
    }

}


