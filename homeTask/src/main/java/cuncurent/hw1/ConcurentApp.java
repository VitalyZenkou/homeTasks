package cuncurent.hw1;

import cuncurent.hw1.Download;

public class ConcurentApp {

    private static final String FIRST_URL = "http://www.nd.ru/download/video/wih1917.wmv";
    private static final String SECOND_URL = "https://aldebaran.ru/author/vern_jyul/kniga_tainstvennyiyi_ostrov/download.a6.pdf";
    private static final String FIRST_FILE = "video.wmv";
    private static final String SECOND_FILE = "book.pdf";

    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadGroup("First Group"), new Download(FIRST_URL, FIRST_FILE), "download video");
        Thread thread1 = new Thread(new ThreadGroup("Second group"), new Download(SECOND_URL, SECOND_FILE), "download book");
        thread.setPriority(Thread.MAX_PRIORITY);
        thread1.setPriority(Thread.NORM_PRIORITY);
        thread1.start();
        thread.start();
        System.out.println(thread);
        System.out.println(thread1);
    }
}
