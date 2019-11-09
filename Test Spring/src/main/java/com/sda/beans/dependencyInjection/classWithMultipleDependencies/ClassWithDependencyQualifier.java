package com.sda.beans.dependencyInjection.classWithMultipleDependencies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClassWithDependencyQualifier {

    @Autowired
    @MarkerXXX
    private InterfaceDependencyWithMultipleImplementation xxx;

    @Autowired
    @MarkerYYY
    private InterfaceDependencyWithMultipleImplementation yyy;

    public InterfaceDependencyWithMultipleImplementation getXxx() {
        return xxx;
    }

    public InterfaceDependencyWithMultipleImplementation getYyy() {
        return yyy;
    }
}
