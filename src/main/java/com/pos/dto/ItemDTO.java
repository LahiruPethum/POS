package com.pos.dto;


import com.pos.entity.enums.MeasuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemDTO {

    private int itemId;
    private String itemName;
    private MeasuringUnitType measureUnitType;
    private double balanceQty;
    private double supplierPrice;
    private double sellingPrice;
    private boolean activeState;




}
