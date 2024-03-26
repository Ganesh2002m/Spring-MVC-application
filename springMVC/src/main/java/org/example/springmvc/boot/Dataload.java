package org.example.springmvc.boot;

import org.example.springmvc.model.Product;
import org.example.springmvc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Dataload implements CommandLineRunner {
    private ProductRepository productRepository;
    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Product product1=new Product();
        product1.setName("KitKat");
        product1.setCategory("Candies");
        product1.setDescription("Have a break ,have a kitkat");
        product1.setPrice(29.99);
        productRepository.save(product1);

        Product product2=new Product();
        product2.setName("DiaryMilk");
        product2.setCategory("Candies");
        product2.setDescription("Sign of Love");
        product2.setPrice(49.99);
        productRepository.save(product2);
    }
}
