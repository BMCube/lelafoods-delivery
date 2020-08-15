package edu.miu.lelafoods.delivery.dao.impl;

import edu.miu.lelafoods.delivery.dao.CartDao;
import edu.miu.lelafoods.delivery.dao.impl.GenericDeliveryDaoImpl;
import edu.miu.lelafoods.delivery.domain.Cart;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unchecked")
@Repository
public class CartDaoImpl extends GenericDeliveryDaoImpl<Cart> implements CartDao {

    public CartDaoImpl(){
        super.setDaoType(Cart.class);
    }
}
