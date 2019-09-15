package com.sda;

import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {

        String savePath = "C:\\Users\\Edmond\\Desktop\\Workplace\\Projects\\youtubeDownloader\\Downloads";
        String url = "";

        Process p;
        try {
            p = Runtime.getRuntime().exec("cmd");
            new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
            new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
            PrintWriter stdin = new PrintWriter(p.getOutputStream());
            stdin.println("cd " + savePath);
            stdin.println(savePath + "\\youtube-dl " + url + " --format 140");
            stdin.close();
            p.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}