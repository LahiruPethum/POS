package com.pos.service.impl;

import com.pos.dto.paginated.PginatedResponseOrderDetailsDTO;
import com.pos.dto.queryInterface.OrderDetailsInterface;
import com.pos.dto.request.RequestOrederSaveDto;
import com.pos.dto.response.ResponseOrderDetailsDTO;
import com.pos.entity.Order;
import com.pos.entity.OrderDetails;
import com.pos.repo.CustomerRepo;
import com.pos.repo.ItemRepo;
import com.pos.repo.OrderDetailsRepo;
import com.pos.repo.OrderRepo;
import com.pos.service.OrderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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

    @Override
    public PginatedResponseOrderDetailsDTO getAllOderDetails(boolean status, int page, int size) {

        List<OrderDetailsInterface> orderDetailsInterfaces = orderRepo.getAllOrderDetails(status, PageRequest.of(page,size));
        System.out.println(orderDetailsInterfaces.get(0).getCustomerName());

        List<ResponseOrderDetailsDTO> list = new ArrayList<>();

        for (OrderDetailsInterface o : orderDetailsInterfaces){
//            ResponseOrderDetailsDTO responseOrderDetailsDTO = new ResponseOrderDetailsDTO(
//              o.getCustomerName(),o.getCustomerAddress(),o.getContactNumbers(),o.getData(),o.getTotal()
//            );

            list.add(
                    new ResponseOrderDetailsDTO(
                            o.getCustomerName(),o.getCustomerAddress(),o.getContactNumbers(),o.getData(),o.getTotal()
                    )
            );
        }
        PginatedResponseOrderDetailsDTO pginatedResponseOrderDetailsDTO = new PginatedResponseOrderDetailsDTO(
                list,
                orderRepo.countAllOrderDetails(status)

        );
        return pginatedResponseOrderDetailsDTO;
    }
}
