package com.sda.beans.scopes;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component(value = "numeDePrototype")
@Scope("prototype")
public class Prototype {

    @PostConstruct
    public void init(){
        System.out.println("init " + this);
    }

}

