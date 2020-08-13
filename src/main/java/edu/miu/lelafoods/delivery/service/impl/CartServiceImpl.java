package edu.miu.lelafoods.delivery.service.impl;

import edu.miu.lelafoods.delivery.dao.CartDao;
import edu.miu.lelafoods.delivery.domain.Cart;
import edu.miu.lelafoods.delivery.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CartServiceImpl implements CartService {

    @Autowired
    CartDao cartDao;

    @Override
    public void save(Cart cart) {

    }


    @Override
    public List<Cart> findall() {
        return cartDao.findAll();
    }

    @Override
    public void deleteCart(long id) {
        cartDao.deleteById(id);

    }

    @Override
    public Cart findById(long id) {
        return cartDao.findOne(id);
    }
}
