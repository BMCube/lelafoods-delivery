package edu.miu.lelafoods.delivery.dao;

import edu.miu.lelafoods.delivery.domain.Delivery;

public interface DeliveryDao extends GenericDeliveryDao<Delivery>{

    public Delivery findByDeliveryPersonName(String name);
}
