package com.sda.beans.scopes;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestPrototype {
    @Test
    public void testPrototype(){
        //container de bean
        ClassPathXmlApplicationContext context;
        context = new ClassPathXmlApplicationContext("spring-com.sda.beans.xml");

        Prototype bean1 = context.getBean(Prototype.class);
        Assert.assertNotNull(bean1);
        Assert.assertSame(Prototype.class,bean1.getClass());

        Prototype bean2 = context.getBean(Prototype.class);
        Assert.assertNotNull(bean2);
        Assert.assertSame(Prototype.class,bean2.getClass());



        Prototype bean3 = (Prototype)context.getBean("numeDePrototype");
        Assert.assertNotNull(bean3);
        Assert.assertSame(Prototype.class,bean3.getClass());

        Assert.assertNotSame(bean1,bean3);

    }

}
