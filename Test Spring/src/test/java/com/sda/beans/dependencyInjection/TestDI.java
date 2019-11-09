package com.sda.beans.dependencyInjection;

import com.sda.beans.dependencyInjection.classWithDependency.ClassWithDependencies;
import com.sda.beans.dependencyInjection.classWithDependency.ClassWithInterfaceDependency;
import com.sda.beans.dependencyInjection.classWithMultipleDependencies.ClassWithDependencyQualifier;
import com.sda.beans.dependencyInjection.classDependency.ClasaA;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDI {
    @Test
    public void testDi() {
        ClassPathXmlApplicationContext context;
        context = new ClassPathXmlApplicationContext("beans.xml");

        ClassWithDependencies bean = context.getBean(ClassWithDependencies.class);
        Assert.assertNotNull(bean.getDependencyField());
        Assert.assertNotNull(bean.getDependencyConstructor());
        Assert.assertNotNull(bean.getDependencySetter());

        ClasaA a = context.getBean(ClasaA.class);
        Assert.assertNotNull(a);

        ClassWithInterfaceDependency classWithInterfaceDependency = context.getBean(ClassWithInterfaceDependency.class);
        Assert.assertNotNull(classWithInterfaceDependency);
        Assert.assertNotNull(classWithInterfaceDependency.getInterfaceDependency());

        ClassWithDependencyQualifier classWithDependencyQualifier = context.getBean(ClassWithDependencyQualifier.class);
        Assert.assertNotNull(classWithDependencyQualifier);
        Assert.assertNotNull(classWithDependencyQualifier.getXxx());
        Assert.assertNotNull(classWithDependencyQualifier.getYyy());
    }

    @Test(expected = org.springframework.beans.factory.UnsatisfiedDependencyException.class)
    public void testDiDoubleImplement() {
        ClassPathXmlApplicationContext context;
        context = new ClassPathXmlApplicationContext("beans.xml","beans-double-implement.xml");
    }

}