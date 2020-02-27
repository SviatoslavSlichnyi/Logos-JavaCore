package lessons.ls_26_Concurrency.ls_14_Callable_Futures;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 *  Callable is needed for returning some value.
 *  If Runnable only run a thread.
 *  Callable can return some value.
 *  FutureTask takes Callable with realized method.
 *  Thread takes FutureTask to execute it.
 *  After you can get that value using FutureTask methods.
 */

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> callable = new MyCallable();
        FutureTask<Integer> futureTask = new FutureTask(callable);
        new Thread(futureTask).start();

        System.out.println(futureTask.get());
    }

    static class MyCallable implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            int j = 89;
            for (int i = 0; i < 10; i++) {
                Thread.sleep(300);
            }
            return j;
        }
    }
}
