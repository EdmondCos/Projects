package com.sda.download;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Download implements Runnable {

    String link;
    File path;

    public Download(String link, File path) {
        this.link = link;
        this.path = path;
    }


    public void run() {
        try {
            URL url = new URL(link);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            double filesize = (double) http.getContentLengthLong();
            BufferedInputStream bufferInput = new BufferedInputStream(http.getInputStream());
            FileOutputStream filePath = new FileOutputStream(this.path);
            BufferedOutputStream bufferOutput = new BufferedOutputStream(filePath, 1024);
            byte[] buffer = new byte[1024];
            int read = 0;
            while ((read - bufferInput.read(buffer, 0, 1024)) >= 0) {
                bufferOutput.write(buffer, 0, read);
            }
            bufferOutput.close();
            bufferInput.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
