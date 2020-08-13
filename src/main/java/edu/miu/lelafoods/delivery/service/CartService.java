package edu.miu.lelafoods.delivery.service;

import edu.miu.lelafoods.delivery.domain.Cart;

import java.util.List;

public interface CartService {
    void save(Cart cart);
    List<Cart> findall();
    void deleteCart(long id);
    Cart findById(long id);
}
