package com.sda;

public class Coffee {
    private ECoffeeType type;

    Coffee(ECoffeeType type) {
        this.type = type;
    }

    public boolean isMyCoffee(ECoffeeType type) {
        return this.type.equals(type);
    }
}
