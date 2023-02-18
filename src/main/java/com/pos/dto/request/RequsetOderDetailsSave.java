package com.pos.dto.request;

import com.pos.entity.Item;
import com.pos.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequsetOderDetailsSave  {

    private String itemName;
    private double qty;
    private Double amount;
private int orders;
    private int items;
}
