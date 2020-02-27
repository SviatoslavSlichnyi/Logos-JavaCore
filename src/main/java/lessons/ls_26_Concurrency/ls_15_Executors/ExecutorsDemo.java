package lessons.ls_26_Concurrency.ls_15_Executors;

import java.util.concurrent.*;

/**
 *  Executor uses for controlling threads:
 *  Number of threads, Duration, Exist, Execution of Threads
 *  Needed to control threads.
 *  Thread Creation is very hard operation.
 *  That is better to continue use the thread which have been done
 *  and ExecutorService can provide us with this possibility.
 */
public class ExecutorsDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        /**
         *  Create 2 threads
         */
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new MyRunnable());
        Future<String> submit = executorService.submit(new MyCallable());
        System.out.println(submit.get());

        executorService.shutdown();

    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("Runnable: working...");
            System.out.println("Runnable: done.");
        }
    }

    static class MyCallable implements Callable<String> {

        @Override
        public String call() throws Exception {
            return "MyCallable returned result";
        }
    }
}
