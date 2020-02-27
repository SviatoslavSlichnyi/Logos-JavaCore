package lessons.ls_26_Concurrency.ls_06_AtomicVarialbe;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicVarsDemo {

    /**
     * The solution of unexpected behavior of primitive variable if Atomic variable wrappers
     */
//    static int i;
    static AtomicInteger i = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        for (int j = 0; j < 10_000; j++) {
            MyThread myThread = new MyThread();
            myThread.start();
            myThread.join();
        }

        /**
         * Sometimes the result can be 9998 or else, but not the 10000.
         * Because operation of increment has to operation inside
         * int temp = i + 1;
         *      <thread="two">
         *          int temp = i + 1;
         *          i = temp;
         *      </>
         * i = temp;
         */
        System.out.println(i);
    }

     static class MyThread extends Thread {
        @Override
        public void run() {
            i.incrementAndGet();
        }
    }

}
