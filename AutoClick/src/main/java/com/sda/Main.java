package com.sda;

import java.awt.event.InputEvent;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter ");

        AutoClick autoClick = new AutoClick();
        int i = 1;
        while(i < 10){
            autoClick.clickMouse(InputEvent.BUTTON1_MASK);
            i++;
        }

        System.out.println(autoClick.getRobot());
    }
}
