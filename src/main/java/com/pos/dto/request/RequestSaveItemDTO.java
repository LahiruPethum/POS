package com.pos.dto.request;

import com.pos.entity.enums.MeasuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequestSaveItemDTO {

    private String itemName;
    private MeasuringUnitType measureUnitType;
    private double balanceQty;
    private double supplierPrice;
    private double sellingPrice;

}
