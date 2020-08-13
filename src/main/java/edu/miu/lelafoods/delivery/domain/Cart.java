package edu.miu.lelafoods.delivery.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cart_id", nullable = false)
    private Long id;

    public Cart() {

    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "delivery_date", length = 19)
    private Date orderdDate;

    @Column(name = "status", length = 20)
    private String orderStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOrderdDate() {
        return orderdDate;
    }

    public void setOrderdDate(Date deliveryDate) {
        this.orderdDate = deliveryDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String status) {
        this.orderStatus = status;
    }
}
