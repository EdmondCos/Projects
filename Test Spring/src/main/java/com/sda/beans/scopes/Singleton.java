package com.sda.beans.scopes;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Lazy // Fa-l doar daca este nevoie, la prima utilizare

public class Singleton {

    @PostConstruct
    public void init(){
        System.out.println("init " + this);
    }
    @PreDestroy
    public void destroy(){
        System.out.println("destroy " + this);
    }
    }

