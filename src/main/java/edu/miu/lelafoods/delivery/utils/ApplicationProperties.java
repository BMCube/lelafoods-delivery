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

    public String getEmailUrl() {
        return emailUrl;
    }
}
