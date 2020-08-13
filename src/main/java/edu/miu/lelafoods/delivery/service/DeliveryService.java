package edu.miu.lelafoods.delivery.service;

import edu.miu.lelafoods.delivery.domain.Delivery;

import java.util.List;

public interface DeliveryService {
    public void save(Delivery delivery);
    public List<Delivery> findall();
    public  void  deleteById(Long id);
    public  Delivery getByDeliveryPersonName(String name);
    public Delivery findById(Long id);
}
