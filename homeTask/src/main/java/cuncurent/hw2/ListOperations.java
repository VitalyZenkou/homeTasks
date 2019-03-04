package cuncurent.hw2;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ListOperations {

    private static final int MAX_SIZE = 10;
    private final LinkedList<Integer> numbers;
    private final ReadWriteLock lock;

    public ListOperations() {
        numbers = new LinkedList<>();
        lock = new ReentrantReadWriteLock(true);
    }

    public void produce() {
        lock.writeLock().lock();
        try {
            Thread.sleep(new Random().nextInt(100) * 10);
            if (numbers.size() < MAX_SIZE) {
                numbers.addFirst(new Random().nextInt());
                System.out.println(String.format("The number %d was added!", numbers.getFirst()));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void consume() {
        lock.readLock().lock();
        try {
            if (!numbers.isEmpty()) {
                Integer i = numbers.removeFirst();
                System.err.println(String.format("The number %d was removed!", i));
            }
        } finally {
            lock.readLock().unlock();
        }
    }
}
