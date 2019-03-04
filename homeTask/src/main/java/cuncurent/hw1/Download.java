package cuncurent.hw1;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class Download implements Runnable {

    private static final String PATH = "homeTask\\src\\main\\resources\\";
    private final String url;
    private final String fileName;

    public Download(String url, String fileName) {
        this.url = url;
        this.fileName = fileName;
    }

    @Override
    public void run() {
        try (BufferedInputStream inputStream = new BufferedInputStream(new URL(url).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(PATH + fileName)) {
            final byte[] data = new byte[1024];
            int count;
            while ((count = inputStream.read(data, 0, 1024)) != -1) {
                fileOutputStream.write(data, 0, count);
            }
        } catch (IOException ex) {
            throw new RuntimeException("Can't write or read file!");
        }
    }
}
