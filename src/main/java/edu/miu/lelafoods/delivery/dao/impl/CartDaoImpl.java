package edu.miu.lelafoods.delivery.domain.dao.impl;

import edu.miu.lelafoods.delivery.domain.Cart;
import edu.miu.lelafoods.delivery.domain.Delivery;
import edu.miu.lelafoods.delivery.domain.dao.CartDao;
import edu.miu.lelafoods.delivery.domain.dao.DeliveryDao;

public class CartDaoImpl extends GenericDeliveryDaoImpl<Cart> implements CartDao {

        public CartDaoImpl(){
            super.setDaoType(Cart.class);
        }
}
