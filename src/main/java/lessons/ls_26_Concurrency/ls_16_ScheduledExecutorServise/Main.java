package lessons.ls_26_Concurrency.ls_16_ScheduledExecutorServise;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *  When it is needed to execute thread with some schedule.
 *  For example:
 *  The thread can be executed after 3 second as it's shown in example.
 */

public class Main {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.schedule(new MyThread(), 3, TimeUnit.SECONDS);
        executorService.shutdown();
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println(1);
        }
    }
}
