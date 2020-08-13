package edu.miu.lelafoods.delivery.domain.dao.impl;

import edu.miu.lelafoods.delivery.domain.Delivery;
import edu.miu.lelafoods.delivery.domain.dao.DeliveryDao;
import edu.miu.lelafoods.delivery.domain.dao.GenericDeliveryDao;

import javax.persistence.Query;

public class DeliveryDaoImpl extends GenericDeliveryDaoImpl<Delivery> implements DeliveryDao {
    public DeliveryDaoImpl(){
        super.setDaoType(Delivery.class);
    }

    @Override
    public Delivery findByDeliveryPersonName(String deliveredByName) {
        Query query = entityManager.createQuery(" select d from Delivery d where d.deliveredBy =:deliveredByName");
        return (Delivery)query.setParameter("deliveredByName", deliveredByName);
    }
}
