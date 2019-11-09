package com.sda.beans.factory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class FactoryProduct {
@Bean
    public Product1 createProduct1() {
        return new Product1();
    }
@Bean
    public Product2 createProduct2() {
        return new Product2();
    }
}
