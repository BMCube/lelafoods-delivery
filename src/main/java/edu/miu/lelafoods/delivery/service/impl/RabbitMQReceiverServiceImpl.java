package edu.miu.lelafoods.delivery.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.miu.lelafoods.delivery.domain.Delivery;
import edu.miu.lelafoods.delivery.dto.CartDto;
import edu.miu.lelafoods.delivery.dto.Order;
import edu.miu.lelafoods.delivery.service.DeliveryService;
import edu.miu.lelafoods.delivery.service.RabbitMQReceiverService;

import edu.miu.lelafoods.delivery.utils.ApplicationProperties;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class RabbitMQReceiverServiceImpl implements RabbitMQReceiverService {

    @Autowired
    Queue queue;
    @Autowired
    DeliveryService deliveryService;
    @Autowired
    ApplicationProperties  applicationProperties;
    RestTemplate restTemplate = new RestTemplate();

    @Override
    @RabbitListener(queues = "lelafoods-order.queue")
    public void receiverCart(CartDto cart) {
        try {
            List<Order> orderList = cart.getOrder();
            //  Cart cartToBeSent = new Cart();
            double totalPrice;
            for (Order order : orderList) {
                //This part should contain same name with the cart model
                totalPrice = order.getFood().getPrice() * order.getOrderQuantity();
                BigDecimal bd = new BigDecimal(totalPrice).setScale(2, RoundingMode.HALF_UP);
                double newTotalPrice = bd.doubleValue();
                order.getFood().setTotal(newTotalPrice);
            }
            //New cart object creation from the received message
            //  cartToBeSent.setOrderList(orderList);
            String cartJson = cartToJson(cart);
            System.out.println("Recieved Message From RabbitMQ: " + cart.toString());
            /*rabbitMQSenderService.sendCartToRestaurant(cart);
            //    rabbitMQSenderService.sendCartEmail(cartJson);*/

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String cartToJson(CartDto cart) {
        ObjectMapper mapper = new ObjectMapper();
        String cartJson = "";
        try {
            cartJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(cart);
            Delivery delivery = new Delivery();
            delivery.setCartId(cart.getId());
            delivery.setAddress(cart.getCustomer().getAddress());
            delivery.setStatus("New Delivery");
            cart.setStatus("New Delivery");
            delivery.setDeliveredDate(new Date());
            delivery.setDeliveredBy("Calu");
            deliveryService.save(delivery);
            sendCartEmail(cart);
            System.out.println("Json to be sent: " + cartJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cartJson;
    }
    public void sendCartEmail(CartDto cartDto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        //Modify the cartDto here to change the subject with relation to restaurant MS
        HttpEntity<?> entity = new HttpEntity<>(cartDto, headers);
        ResponseEntity<String> response = restTemplate.exchange(applicationProperties.getEmailUrl(), HttpMethod.POST, entity, String.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            System.out.println("Email sent successfully:  " + response.getBody());
        } else {
            System.err.println("Email sent failed please try again");
        }
    }


}
