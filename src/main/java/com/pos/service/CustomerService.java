package com.pos.service;

import com.pos.dto.CustomerDTO;

public interface CustomerService {


    void addCustomer(CustomerDTO customerDTO);

    String updateCustomer(CustomerDTO customerDTO);

    CustomerDTO getCustormerById(int customerId);
}
