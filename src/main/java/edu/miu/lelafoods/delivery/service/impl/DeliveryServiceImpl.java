package edu.miu.lelafoods.delivery.service.impl;

import edu.miu.lelafoods.delivery.dao.CartDao;
import edu.miu.lelafoods.delivery.dao.DeliveryDao;
import edu.miu.lelafoods.delivery.domain.Delivery;
import edu.miu.lelafoods.delivery.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    DeliveryDao deliveryDao;
    @Autowired
    CartDao cartDao;

    @Override
    public void save(Delivery delivery) {

        deliveryDao.save(delivery);

    }

    @Override
    public List<Delivery> findall() {
        return deliveryDao.findAll();
    }

    @Override
    public void deleteById(Long id) {
        deliveryDao.deleteById(id);

    }

    @Override
    public Delivery getByDeliveryPersonName(String name) {
        return getByDeliveryPersonName(name);
    }

    @Override
    public Delivery findById(Long id) {
        return deliveryDao.findOne(id);
    }
}
