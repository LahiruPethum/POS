package com.pos.entity;

import com.pos.entity.enums.MeasuringUnitType;
import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "orders")
@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonType.class)
})
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order {

    @Id
    @Column(name="Order_id", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;

    @ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
    private Customer customer;

    @Column(name = "order_date",columnDefinition = "DATETIME")
    private Date data;

    @Column(name = "total",nullable = false)
    private Double total;

    @Column(name = "active_state", columnDefinition = "TINYINT default 1")
    private boolean activeState;

    @OneToMany(mappedBy = "orders")
    private Set<OrderDetails> orderDetails;



    public Order(Customer customer, Date data, Double total) {
        this.customer = customer;
        this.data = data;
        this.total = total;
    }
}
