package lessons.ls_26_Concurrency.ls_02_join_yield_sleep;

import java.util.concurrent.atomic.AtomicInteger;

public class JoinDemo {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread starts.");

        MyThread firstThread = new MyThread();
        MyThread secondThread = new MyThread();

        firstThread.start();
        secondThread.start();

        /**
         * Join tells the current thread (`main`) wait
         * after `firstThread` ends
         * the current thread can continue to do code
         */
        firstThread.join();

        System.out.println("Main thread ends.");
    }

    private static class MyThread extends Thread {

        private static AtomicInteger integer = new AtomicInteger(-1);
        private static final int id = integer.incrementAndGet();

        @Override
        public void run() {
            System.out.println("MyThread #" + id);
        }
    }
}
