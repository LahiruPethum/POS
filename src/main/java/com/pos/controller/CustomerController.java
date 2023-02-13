package com.pos.controller;


import com.pos.dto.CustomerDTO;
import com.pos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping(path = "/update")
    public String updateCustomer(@RequestBody CustomerDTO customerDTO){
        String update = custermerService.updateCustomer(customerDTO);
        return update;
    }

    @GetMapping(path="/get-by-id",
                params = "id")
    public CustomerDTO getCustomerById(@RequestParam(value = "id") int customerId){
        CustomerDTO customerDTO=custermerService.getCustormerById(customerId);
        return customerDTO;
    }

    @GetMapping(path="get-all-customers")
    public List<CustomerDTO> getAllCustomers(){
        List<CustomerDTO> allCustomers=custermerService.getAllCustomers();
        return allCustomers;
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteCustomer(@PathVariable(value = "id")int customerId){
        String deleted=custermerService.deleteCustomer(  customerId);
return deleted;
    }


}
