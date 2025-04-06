package com.spring.core.entities;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class Cart {

    private List<Product> cart = new ArrayList<>();

    public List<Product> getCart() {
        return new ArrayList<>(cart);
    }

    public void add(Product product){
        cart.add(product);
    }

    public void clear(){
        cart.clear();
    }

    public double getTotal(){
        return cart.stream().mapToDouble(Product::getCost).sum();
    }
}
