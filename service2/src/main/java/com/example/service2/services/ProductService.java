package com.example.service2.services;

import com.example.service2.entities.Product;
import com.example.service2.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public void addProduct(Product p) {
        productRepository.save(p);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public List<Product> getProductsByPrice(double price) {
        List<Product> result = new ArrayList<>();
        List<Product> products = productRepository.findAll();

        for (Product p : products) {
            if (p.getPrice() > price) {
                result.add(p);
            }
        }

        return result;
    }

}