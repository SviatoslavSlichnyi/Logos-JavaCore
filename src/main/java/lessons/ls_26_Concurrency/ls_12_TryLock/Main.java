package lessons.ls_26_Concurrency.ls_12_TryLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * tryLock() - is a method to find out the object is Locked or not
 */
public class Main {

    static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        new Thread1().start();
        new Thread2().start();
    }

    static class Thread1 extends Thread {
        @Override
        public void run() {
            lock.lock();
            System.out.println(getName() + " starts working");
            try {
                sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName() + " stops working");
            lock.unlock();
            System.out.println(getName() + " lock is released");
        }
    }

    static class Thread2 extends Thread {
        @Override
        public void run() {
            System.out.println(getName() + " begin working");
            while (true) {
                if (lock.tryLock()) {
                    System.out.println(getName() + " working");
                    break;
                } else {
                    System.out.println(getName() + "waiting");
                }
            }
        }
    }
}
