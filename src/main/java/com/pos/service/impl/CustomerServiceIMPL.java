package com.pos.service.impl;

import com.pos.dto.CustomerDTO;
import com.pos.entity.Customer;
import com.pos.repo.CustomerRepo;
import com.pos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;
    @Override
    public void addCustomer(CustomerDTO customerDTO) {
        Customer customer= new Customer(
                customerDTO.getCustomerId(),
                customerDTO.getCustomerName(),
                customerDTO.getCustomerAddress(),
                customerDTO.getCustomerSalary(),
                customerDTO.getContactNumbers(),
                customerDTO.getNic(),
                customerDTO.isActiveState()
        );

        if (!customerRepo.existsById(customer.getCustomerId())){
            customerRepo.save(customer);
        }else {
            System.out.println("already in table");
        }
    }
}
