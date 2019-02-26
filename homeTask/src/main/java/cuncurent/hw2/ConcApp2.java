package cuncurent.hw2;

import java.util.Random;

public class ConcApp2 {

    public static void main(String[] args) {
        ListOperations lo = new ListOperations();

        new Thread(() -> {
            while (true) {
                lo.produce();
            }
        }).start();

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(new Random().nextInt(100) * 10);
                    lo.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException();
                }
            }
        }).start();
    }
}
