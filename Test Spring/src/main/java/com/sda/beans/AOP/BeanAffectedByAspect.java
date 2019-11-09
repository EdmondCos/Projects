package com.sda.beans.AOP;

import org.springframework.stereotype.Component;

@Component
public class BeanAffectedByAspect {

    public void doSomething() {
        System.out.println(this + " did something");
    }

}
