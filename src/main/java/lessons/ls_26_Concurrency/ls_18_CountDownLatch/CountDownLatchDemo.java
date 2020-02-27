package lessons.ls_26_Concurrency.ls_18_CountDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 *  We can set the number of thread to be finished
 *  after we continue to do the another work (thread).
 */

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        int numberOfThreadsToBeFinished = 3;
        CountDownLatch countDownLatch = new CountDownLatch(numberOfThreadsToBeFinished);

        new Work(countDownLatch);
        new Work(countDownLatch);
        new Work(countDownLatch);
        new Work(countDownLatch);

        countDownLatch.await();
        System.out.println("all jobs done");
    }

}

class Work extends Thread {
    CountDownLatch countDownLatch;

    public Work(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
        start();
    }

    @Override
    public void run() {
        try {
            sleep(3_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("work is done");
        countDownLatch.countDown();
    }
}
