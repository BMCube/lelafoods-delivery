package edu.miu.lelafoods.delivery.domain.dao.impl;

import edu.miu.lelafoods.delivery.domain.Address;
import edu.miu.lelafoods.delivery.domain.Cart;
import edu.miu.lelafoods.delivery.domain.dao.AddressDao;
import edu.miu.lelafoods.delivery.domain.dao.CartDao;

public class AddressDaoImpl extends GenericDeliveryDaoImpl<Address> implements AddressDao {
    public AddressDaoImpl(){
        super.setDaoType(Address.class);
    }

}
