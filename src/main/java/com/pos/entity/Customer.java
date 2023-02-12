package com.pos.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "customer")
@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonType.class)
})
public class Customer {

    @Id
    @Column(name = "customer_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;

    @Column(name = "customer_name",length = 100,nullable = false)
    private String customerName;

    @Column(name = "customer_address",length = 255)
    private String custormerAddress;

    @Column(name="customer_salary")
    private double customersalary;

    @Type(type = "json")
    @Column(name = "contact_numbers",columnDefinition = "json")
    private ArrayList contactNumbers;

    @Column(name="nic")
    private String nic;

    @Column(name = "active_state", columnDefinition = "TINYINT default 1")
    private boolean activeState;

    public Customer() {
    }

    public Customer(int customerId, String customerName, String custormerAddress, double customersalary, ArrayList contactNumbers, String nic, boolean activeState) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.custormerAddress = custormerAddress;
        this.customersalary = customersalary;
        this.contactNumbers = contactNumbers;
        this.nic = nic;
        this.activeState = activeState;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustormerAddress() {
        return custormerAddress;
    }

    public void setCustormerAddress(String custormerAddress) {
        this.custormerAddress = custormerAddress;
    }

    public double getCustomersalary() {
        return customersalary;
    }

    public void setCustomersalary(double customersalary) {
        this.customersalary = customersalary;
    }

    public ArrayList getContactNumbers() {
        return contactNumbers;
    }

    public void setContactNumbers(ArrayList contactNumbers) {
        this.contactNumbers = contactNumbers;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public boolean isActiveState() {
        return activeState;
    }

    public void setActiveState(boolean activeState) {
        this.activeState = activeState;
    }
}
