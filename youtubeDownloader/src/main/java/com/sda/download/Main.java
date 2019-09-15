package com.sda.download;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        String link = "https://www.youtube.com/watch?v=rd6m-6l2xQQ&t=640s";
        File path = new File("C:\\Users\\Elena The Bo$$\\Desktop\\Workplace\\test.mp3");

        new Thread(new Download(link,path));
    }
}
