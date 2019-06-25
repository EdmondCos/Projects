package com.sda;

public enum ECoffeeType {
    ESPRESSO(7, 200, 0),
    CAPPUCCINO(7, 150, 50);

    public final int requiredBeans;
    public final int requiredWater;
    public final int requiredMilk;

    ECoffeeType(int requiredBeans, int requiredWater, int requiredMilk) {
        this.requiredBeans = requiredBeans;
        this.requiredWater = requiredWater;
        this.requiredMilk = requiredMilk;
    }
}
