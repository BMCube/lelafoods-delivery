package edu.miu.lelafoods.delivery.domain;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "delivery")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "delivery_id")
    private Long id;
//    @NotNull(message = "notnull")
    @Temporal(TemporalType.DATE)
    @Column(name = "delivered_date", length = 19)
    private Date deliveredDate;
    @NotEmpty(message = "name.delivered")
    @Column(name = "delivered_by", length = 20)
    private String deliveredBy;
    @NotNull(message = "notnull")
    @Column(name = "delivery_status",  length = 20)
    private String status;
    @Valid
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "address_Id")
    private Address address;

    private Long cartId;
    public Long getId() {
        return id;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDeliveredDate() {
        return deliveredDate;
    }

    public void setDeliveredDate(Date deliveredDate) {
        this.deliveredDate = deliveredDate;
    }

    public String getDeliveredBy() {
        return deliveredBy;
    }

    public void setDeliveredBy(String deliveredBy) {
        this.deliveredBy = deliveredBy;
    }

    public String getStatus() {
        return status;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setStatus(String status) {
        this.status = status;
    }




}
