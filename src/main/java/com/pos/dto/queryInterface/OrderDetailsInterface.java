package com.pos.dto.queryInterface;

import java.util.ArrayList;
import java.util.Date;

public interface OrderDetailsInterface {

    String getCustomerName();
    String getCustomerAddress();
    ArrayList getContactNumbers();

    Date getData();
    Double getTotal();


}
