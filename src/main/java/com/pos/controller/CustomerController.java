package com.pos.controller;


import com.pos.dto.CustomerDTO;
import com.pos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService custermerService;


    @PostMapping(path = "/save")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO){
        custermerService.addCustomer(customerDTO);
        return "saved";
    }
}
