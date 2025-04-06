package com.spring.core;

import com.spring.core.entities.Cart;
import com.spring.core.entities.Product;
import com.spring.core.service.OrderService;
import com.spring.core.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class CoreApplication {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(CoreApplication.class, args);

		ProductService productService = context.getBean(ProductService.class);
		Cart cart = context.getBean(Cart.class);
		OrderService orderService = context.getBean(OrderService.class);

		// Демонстрация работы
		productService.printAll();

		// Добавляем товары в корзину
		Product product1 = productService.findByTitle("Product 1");
		Product product2 = productService.findByTitle("Product 2");

		if (product1 != null) cart.add(product1);
		if (product2 != null) cart.add(product2);

		// Формируем заказ
		orderService.createOrder(cart);
	}
}
