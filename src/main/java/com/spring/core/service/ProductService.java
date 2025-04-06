package com.spring.core.service;

import com.spring.core.entities.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private List<Product> productList = new ArrayList<>();

    public void printAll(){
        System.out.println("All products:");
        productList.forEach(System.out::println);
    }

    public Product findByTitle(String title){
        return productList.stream()
                .filter(p -> p.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }

    @PostConstruct
    public void fillProducts(){
        for (int i = 1; i < 11; i++) {
            productList.add(new Product(i, "Product "+ i, 10+i));
        }
    }
}
