package edu.miu.lelafoods.delivery.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApplicationProperties {

    @Value("${lelafoods-order.rabbitmq.queue}")
    private String queueName;

    @Value("${lelafoods-order.rabbitmq.exchange}")
    private String exchange;

    @Value("${lelafoods-order.rabbitmq.routingkey}")
    private String routingkey;

    @Value("${lelafoods-eai.rabbitmq.queue}")
    private String eaiQueueName;

//    @Value("${lelafoods-eai.rabbitmq.exchange}")
//    private String eaiExchange;

    @Value("${lelafoods-eai.rabbitmq.routingkey}")
    private String eaiRoutingkey;

    @Value("${notification.url}")
    private String emailUrl;

    public String getRoutingkey() {
        return routingkey;
    }

    public String getExchange() {
        return exchange;
    }

    public String getQueueName() {
        return queueName;
    }

    public String getEaiQueueName() {
        return eaiQueueName;
    }

//    public String getEaiExchange() {
//        return eaiExchange;
//    }

    public String getEaiRoutingkey() {
        return eaiRoutingkey;
    }

    public String getEmailUrl() {
        return emailUrl;
    }
}
