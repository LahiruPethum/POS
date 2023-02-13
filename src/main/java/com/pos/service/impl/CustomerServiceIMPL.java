package com.pos.service.impl;

import com.pos.dto.CustomerDTO;
import com.pos.entity.Customer;
import com.pos.repo.CustomerRepo;
import com.pos.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;


    //post
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








    //put
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
//search
    //method 1 using getById



//    public CustomerDTO getCustormerById(int customerId) {
//
//        Customer customer = customerRepo.getById(customerId);
//
//        if (customer!=null){
//            CustomerDTO customerDTO=new CustomerDTO(
//                    customer.getCustomerId(),
//                    customer.getCustomerName(),
//                    customer.getCustormerAddress(),
//                    customer.getCustomersalary(),
//                    customer.getContactNumbers(),
//                    customer.getNic(),
//                    customer.isActiveState()
//            );
//
//
//            return customerDTO;
//        }else {
//            return null;
//        }
//
//
//    }


    //method 2 using findBiId
//    public CustomerDTO getCustormerById(int customerId) {
//
//        Optional<Customer> customer = customerRepo.findById(customerId);
//
//        if (customer.isPresent()){
//            CustomerDTO customerDTO=new CustomerDTO(
//                    customer.get().getCustomerId(),
//                    customer.get().getCustomerName(),
//                    customer.get().getCustormerAddress(),
//                    customer.get().getCustomersalary(),
//                    customer.get().getContactNumbers(),
//                    customer.get().getNic(),
//                    customer.get().isActiveState()
//            );
//
//
//            return customerDTO;
//        }else {
//            return null;
//        }
//
//
//    }


    //method 3 using model mapping
        public CustomerDTO getCustormerById(int customerId) {

        Customer customer = customerRepo.getById(customerId);

        CustomerDTO customerDTO = modelMapper.map(customer, CustomerDTO.class);
        return customerDTO;
    }









    //get all
    @Override
//    public List<CustomerDTO> getAllCustomers() {
//
//        List<Customer> getall = customerRepo.findAll();
//        List<CustomerDTO> customerDTOList = new ArrayList<>();
//
//        for (Customer customer:getall){
//            CustomerDTO customerDTO= new CustomerDTO(
//                    customer.getCustomerId(),
//                    customer.getCustomerName(),
//                    customer.getCustormerAddress(),
//                    customer.getCustomersalary(),
//                    customer.getContactNumbers(),
//                    customer.getNic(),
//                    customer.isActiveState()
//            );
//
//            customerDTOList.add(customerDTO);
//        }
//        return customerDTOList;
//
//    }

//    public List<CustomerDTO> getAllCustomers() {
//        List<Customer> getall = customerRepo.findAll();
//        List<CustomerDTO> customerDTOList = new ArrayList<>();
//
//        for (Customer customer:getall){
//            CustomerDTO customerDTO = modelMapper.map(customer, CustomerDTO.class);
//
//            customerDTOList.add(customerDTO);
//        }
//        return customerDTOList;
//
//    }

    public List<CustomerDTO> getAllCustomers() {

        List<Customer> getall = customerRepo.findAll();
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        if (customerDTOList!=null){
            customerDTOList=modelMapper.
                    map(getall,new TypeToken<List<CustomerDTO>>(){
            }.getType());
        }
        return customerDTOList;

    }



    //delete
    @Override
    public String deleteCustomer(int customerId) {
        if (customerRepo.existsById(customerId)){
            customerRepo.deleteById(customerId);
            return "Deleted";
        }else {
            return "No customer that id";
        }
    }

}