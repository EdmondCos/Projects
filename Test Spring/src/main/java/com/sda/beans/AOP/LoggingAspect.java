package com.sda.beans.AOP;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Before(value = "execution(* com.sda.beans.AOP.*.*(..))")
    void aspectExecutedBeforeExecutingTargetedMethods() {
        System.out.println("before executing method call BEFORE");
    }

    @After(value = "execution(* com.sda.beans.AOP.*.*(..))")
    void aspectExecutedAfterExecutingTargetedMethods() {
        System.out.println("after executing method call AFTER");
    }
}
