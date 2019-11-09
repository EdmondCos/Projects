package com.sda.beans.scopes;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSingleton {
    @Test
    public void testSingleton(){
        //container de bean
        ClassPathXmlApplicationContext context;
        context = new ClassPathXmlApplicationContext("spring-com.sda.beans.xml");

        Singleton bean1 = context.getBean(Singleton.class);
        Assert.assertNotNull(bean1);
        Assert.assertSame(Singleton.class,bean1.getClass());

        Singleton bean2 = context.getBean(Singleton.class);
        Assert.assertNotNull(bean2);
        Assert.assertSame(Singleton.class,bean2.getClass());


        Singleton bean3 = (Singleton) context.getBean("singleton");
        Assert.assertNotNull(bean3);
        Assert.assertSame(Singleton.class,bean3.getClass());


        Assert.assertSame(bean1,bean2);
        Assert.assertSame(bean1,bean3);
        context.destroy();
    }

}

