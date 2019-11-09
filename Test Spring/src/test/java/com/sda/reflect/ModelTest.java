package com.sda.reflect;


import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;

// Test reflection
public class ModelTest {
    private Model model = new Model();

    @Test
    public void testX() {
        assertEquals(3, model.getX());
    }

    @Test
    public void testImportedField() throws Exception {
        Field x = model.getClass().getDeclaredField("x");
        x.setAccessible(true);
        Object obj = x.get(model);
        assertEquals(3, obj);

        //change value of X
        x.set(model, 2);
        assertEquals(2, model.getX());
    }

    @Test
    public void testImportedMethod() throws Exception {
        //sau model.getClass()
        Method method = Model.class.getDeclaredMethod("service", int.class);
        method.setAccessible(true);
        Object serviceResult = method.invoke(model, 2);
        assertEquals(6, serviceResult);
    }
}