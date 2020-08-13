package edu.miu.lelafoods.delivery.dao.impl;

import edu.miu.lelafoods.delivery.dao.DeliveryDao;
import edu.miu.lelafoods.delivery.dao.impl.GenericDeliveryDaoImpl;
import edu.miu.lelafoods.delivery.domain.Delivery;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

@SuppressWarnings("unchecked")
@Repository
public class DeliveryDaoImpl extends GenericDeliveryDaoImpl<Delivery> implements DeliveryDao {
    public DeliveryDaoImpl(){
        super.setDaoType(Delivery.class);
    }

    @Override
    public Delivery findByDeliveryPersonName(String deliveredBy) {
        Query query = entityManager.createQuery(" select d from Delivery d where d.deliveredBy =:deliveredBy");
        return (Delivery)query.setParameter("deliveredBy", deliveredBy);
    }
}
