package edu.miu.lelafoods.delivery.service;


import edu.miu.lelafoods.delivery.domain.Cart;
import edu.miu.lelafoods.delivery.dto.CartDto;

public interface RabbitMQReceiverService {
	public void receiverCart(CartDto cartDto);
	public String cartToJson(CartDto cartDto);
	void sendCartEmail(CartDto cartDto);
}