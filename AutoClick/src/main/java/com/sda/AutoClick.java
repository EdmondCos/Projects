package com.sda;

import java.awt.*;

public class AutoClick {

    private Robot robot;
    private int delay;

    public AutoClick() {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        delay = 300;
    }

    public void clickMouse(int button){
        try {
            robot.mousePress(button);
            robot.delay(100);
            robot.mouseRelease(button);
            robot.delay(delay);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getRobot() {
        return robot.toString();
    }
}
