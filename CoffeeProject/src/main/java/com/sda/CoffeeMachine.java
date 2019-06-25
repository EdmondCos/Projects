package com.sda;

public class CoffeeMachine implements IMachineFunctions {

    private int beans;
    private int water;
    private int milk;

    public CoffeeMachine() {
        beans = 100;
        water = 1000;
        milk = 1000;
    }

    @Override
    public Coffee brew(ECoffeeType type) {
        if (beans >= type.requiredBeans && water >= type.requiredWater && milk >= type.requiredMilk) {
            beans = beans - type.requiredBeans;
            water = water - type.requiredWater;
            milk = milk - type.requiredMilk;
            return new Coffee(type);
        } else {
            String errorMessage = "Not enough ";
            if (beans < type.requiredBeans) {
                errorMessage += "beans";
            }
            if (water < type.requiredWater) {
                errorMessage += "water";
            }
            if (milk < type.requiredMilk) {
                errorMessage += "milk";
            }
            throw new IllegalArgumentException(errorMessage);
        }
    }

    @Override
    public void restock() {
        beans = 100;
        water = 1000;
        milk = 1000;
    }
}
