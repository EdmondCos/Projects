package com.sda.reflect;

public class Model {
    private int x = 3;

    private int service(int y) {
        int result = x * y;
        return result;
    }

    public int getX() {
        return x;
    }
}
