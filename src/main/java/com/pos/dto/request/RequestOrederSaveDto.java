package com.pos.dto.request;

import com.pos.entity.Customer;
import com.pos.entity.OrderDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequestOrederSaveDto {


    private int customer;
    private Date data;
    private Double total;
    private List<RequsetOderDetailsSave> orderDetails;
}
