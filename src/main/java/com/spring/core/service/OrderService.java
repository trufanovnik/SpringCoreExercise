package com.spring.core.service;

import com.spring.core.entities.Cart;
import com.spring.core.entities.Product;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    public void createOrder(Cart cart){
        double total = cart.getCart().stream()
                .peek(p -> System.out.printf("%s - $%.2f%n", p.getTitle(), p.getCost()))
                .mapToDouble(Product::getCost)
                .sum();

        System.out.printf("Total: $%.2f%n", total);
        cart.clear();
    }
}
