package com.pos.service.impl;

import com.pos.dto.CustomerDTO;
import com.pos.entity.Customer;
import com.pos.repo.CustomerRepo;
import com.pos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public void addCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(
                customerDTO.getCustomerId(),
                customerDTO.getCustomerName(),
                customerDTO.getCustomerAddress(),
                customerDTO.getCustomerSalary(),
                customerDTO.getContactNumbers(),
                customerDTO.getNic(),
                customerDTO.isActiveState()
        );

        if (!customerRepo.existsById(customer.getCustomerId())) {
            customerRepo.save(customer);
        } else {
            System.out.println("already in table");
        }
    }

    @Override
    public String updateCustomer(CustomerDTO customerDTO) {
        if (customerRepo.existsById(customerDTO.getCustomerId())) {
            Customer customer = customerRepo.getById(customerDTO.getCustomerId());

            customer.setCustomerName(customerDTO.getCustomerName());
            customer.setCustomersalary(customerDTO.getCustomerSalary());
            customer.setCustormerAddress(customerDTO.getCustomerAddress());

            customerRepo.save(customer);
            return "updated";

        }else {
            System.out.println("no custermer to update");
        }
        return "no custermer to update";
    }

    @Override
    public CustomerDTO getCustormerById(int customerId) {

        Customer customer = customerRepo.getById(customerId);

        if (customer!=null){
            CustomerDTO customerDTO=new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustormerAddress(),
                    customer.getCustomersalary(),
                    customer.getContactNumbers(),
                    customer.getNic(),
                    customer.isActiveState()
            );


            return customerDTO;
        }else {
            return null;
        }


    }
}