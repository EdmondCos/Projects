package com.sda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;

public class Main {
    private JButton Download;
    JPanel Main;
    private JTextField url;

    private String savePath = "C:\\Users\\Edmond\\Desktop\\Workplace\\Projects\\youtubeDownloader\\Downloads";

    Main() {
        Download.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {

                Process p;
                try {
                    p = Runtime.getRuntime().exec("cmd");
                    new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
                    new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
                    PrintWriter stdin = new PrintWriter(p.getOutputStream());
                    stdin.println("cd " + savePath);
                    stdin.println(savePath + "\\youtube-dl " + url.getText() + " --format 140");
                    stdin.close();
                    p.waitFor();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Youtue Downloader");
        frame.setContentPane(new Main().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

}
