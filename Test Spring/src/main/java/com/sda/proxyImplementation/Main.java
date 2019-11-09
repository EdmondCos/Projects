package com.sda.proxyImplementation;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        ServiceInterface serviceInterface = createProxy();
        String result = serviceInterface.execute();
        System.out.println(result);
    }

    private static ServiceInterface createProxy() {
        ServiceInterface proxy;

//        get class loader
            ClassLoader classLoader = Main.class.getClassLoader();

//        specify proxy targeted interface
//        proxy targeted interface must contain all interfaces this proxy can cast to
            Class<?>[] interfaces = new Class[]{ServiceInterface.class};

//        build an invoker handles used for all methods invoked on proxy
            InvocationHandler handler = new InvocationHandler() {
                ServiceImplementation serviceImplementation = new ServiceImplementation();
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                    return serviceImplementation.execute();
                    System.out.println("inceput metoda");
                    Object result =  method.invoke(serviceImplementation, args);
                    System.out.println("terminare metoda");
                    return result;
                }
            };

//        build the proxy
            proxy = (ServiceInterface) java.lang.reflect.Proxy.newProxyInstance(classLoader, interfaces, handler);

        return proxy;
    }
}

