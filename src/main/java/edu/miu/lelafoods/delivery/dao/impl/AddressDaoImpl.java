package edu.miu.lelafoods.delivery.dao.impl;

import edu.miu.lelafoods.delivery.dao.AddressDao;
import edu.miu.lelafoods.delivery.domain.Address;
import org.springframework.stereotype.Repository;


@SuppressWarnings("unchecked")
@Repository
public class AddressDaoImpl extends GenericDeliveryDaoImpl<Address> implements AddressDao {
    public AddressDaoImpl(){
        super.setDaoType(Address.class);
    }

}
