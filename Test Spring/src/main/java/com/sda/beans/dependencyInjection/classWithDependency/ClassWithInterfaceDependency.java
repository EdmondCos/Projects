package com.sda.beans.dependencyInjection.classWithDependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClassWithInterfaceDependency {

    @Autowired
    private InterfaceDependency interfaceDependency;

    public InterfaceDependency getInterfaceDependency() {
        return interfaceDependency;
    }
}
