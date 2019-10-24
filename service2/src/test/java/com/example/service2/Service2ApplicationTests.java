package com.example.service2;

import com.example.service2.entities.Product;
import com.example.service2.repositories.ProductRepository;
import com.example.service2.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;

@SpringBootTest
class Service2ApplicationTests {

    @MockBean
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @Test
    void getProductPriceTest(){
        List<Product> result =new ArrayList<>();
        Product p1= new Product ();
        p1.setName ("Beer");
        p1.setPrice(10);

        Product p2= new Product ();
        p2.setName ("Chocolate");
        p2.setPrice(15);

        result.add(p1);
        result.add(p2);



        given(productRepository.findAll()).willReturn(result);

        List<Product> products = productService.getProductsByPrice(11);

        for(Product p : products) {
            assertTrue( p.getPrice()> 11);
        }

    }

}
