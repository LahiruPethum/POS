package com.pos.service.impl;

import com.pos.dto.request.RequestOrederSaveDto;
import com.pos.entity.Order;
import com.pos.entity.OrderDetails;
import com.pos.exception.NotFoundExcption;
import com.pos.repo.CustomerRepo;
import com.pos.repo.ItemRepo;
import com.pos.repo.OrderDetailsRepo;
import com.pos.repo.OrderRepo;
import com.pos.service.OrderService;
import com.pos.utill.mappers.ItemMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private OrderDetailsRepo orderDetailsRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ItemRepo itemRepo;



    @Override
    @Transactional
    public String addOrder(RequestOrederSaveDto requestOrederSaveDto) {
        Order order = new Order(
                customerRepo.getById(requestOrederSaveDto.getCustomer()),
                requestOrederSaveDto.getData(),
                requestOrederSaveDto.getTotal()

        );
        orderRepo.save(order);
        if (orderRepo.existsById(order.getOrderId())) {
            List<OrderDetails> orderDetails = modelMapper.map(
                    requestOrederSaveDto.getOrderDetails(), new TypeToken<List<OrderDetails>>() {

                    }.getType()
            );

            for (int i=0;i<orderDetails.size();i++){
                orderDetails.get(i).setOrders(order);
                orderDetails.get(i).setItems(itemRepo.getById(requestOrederSaveDto.getOrderDetails().get(i).getItems()));
            }
//
            if (orderDetails.size() > 0) {
                orderDetailsRepo.saveAll(orderDetails);

            }
            return "saved";
//
        }
        return null;
    }
}
