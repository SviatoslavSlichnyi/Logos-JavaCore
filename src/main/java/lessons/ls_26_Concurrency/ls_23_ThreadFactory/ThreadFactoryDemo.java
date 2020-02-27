package lessons.ls_26_Concurrency.ls_23_ThreadFactory;

import java.util.concurrent.ThreadFactory;

/**
 *  ThreadFactory is used when that is needed to configure Thread object.
 */

public class ThreadFactoryDemo {
    public static void main(String[] args) {
        ThreadFactory threadFactory = runnable -> {
            Thread t = new Thread(runnable);
            t.setPriority(Thread.MAX_PRIORITY);
            return t;
        };

        threadFactory.newThread(new MyRun()).start();
    }

    static class MyRun implements Runnable {
        @Override
        public void run() {
            System.out.println("My runnable");
        }
    }

}
