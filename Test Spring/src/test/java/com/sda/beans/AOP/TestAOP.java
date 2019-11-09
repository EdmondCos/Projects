package com.sda.beans.AOP;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAOP {
    @Test
    public void testAOP() {
        ClassPathXmlApplicationContext context;
        context = new ClassPathXmlApplicationContext("beans.xml");

        BeanAffectedByAspect bean = context.getBean(BeanAffectedByAspect.class);
        bean.doSomething();

    }
}