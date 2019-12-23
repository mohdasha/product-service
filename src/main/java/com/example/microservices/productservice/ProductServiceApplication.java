package com.example.microservices.productservice;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}
	
	@RabbitListener(queues = "orderQueue")
	public void listen(String message) {
		System.out.println("Message received on 'orderQueue': "+message);
	}
}
