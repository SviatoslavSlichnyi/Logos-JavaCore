package lessons.ls_26_Concurrency.ls_25_ThreadLocalRandom;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 *  ThreadLocalRandom for random values
 *  TimeUnit for converting millisecond to other form
 */

public class ThreadLocalRandomDemo {
    public static void main(String[] args) throws InterruptedException {
        //MISTAKE: it is not save using while
        //System.out.println(Math.random());

        //The better way is using ThreadLocal class
        System.out.println(ThreadLocalRandom.current().nextInt());


        Thread.sleep(TimeUnit.SECONDS.toMillis(33));
    }
}
