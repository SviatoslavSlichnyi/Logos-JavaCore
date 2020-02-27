package lessons.ls_26_Concurrency.ls_02_join_yield_sleep;

public class YieldDemo {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread: starts.");

        MyThread myThread = new MyThread();
        MyYieldThread myYieldThread = new MyYieldThread();

        myThread.start();
        myYieldThread.start();

        /**Yields make the current thread to sleep.
         * That means the another thread could be executed
         */
        Thread.yield();

        System.out.println("Main thread: ends.");
    }

    private static class  MyYieldThread extends Thread {
        @Override
        public void run() {
            System.out.println("MyYieldThread: starts");

            int a;
            for (int i = 0; i < 1_000_000; i++) {
                a = i;

                if (i == 500_000) {
                    /**Yields make the current thread to sleep.
                     * That means the another thread could be executed
                     */
                    Thread.yield();
                }
            }

            System.out.println("MyYieldThread: ends");
        }
    }

    private static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("MyThread: starts");

            int b;
            for (int i = 0; i < 1_000_000; i++) {
                b = i;
            }

            System.out.println("MyThread: ends");
        }
    }

}

