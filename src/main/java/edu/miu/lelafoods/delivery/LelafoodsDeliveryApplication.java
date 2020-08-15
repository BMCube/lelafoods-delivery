package edu.miu.lelafoods.delivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LelafoodsDeliveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(LelafoodsDeliveryApplication.class, args);
    }

}
