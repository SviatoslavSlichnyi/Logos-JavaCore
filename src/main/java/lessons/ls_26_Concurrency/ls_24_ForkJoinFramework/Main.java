package lessons.ls_26_Concurrency.ls_24_ForkJoinFramework;


import homework.ls_22_LamdaOptional.my_functions.MyConsumer;

import java.util.Date;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 *  ForkJoinPool is needed to split one task into some threads
 */

public class Main {

    static long numOfOperations = 2_000_000_000L;

    static int numOfCoresInProcessor = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {
//        System.out.println("number of cores: " + numOfCoresInProcessor);
        System.out.println(new Date());

        ForkJoinPool pool = new ForkJoinPool(numOfCoresInProcessor);
        System.out.println(pool.invoke(new MyFork(0, numOfOperations)));

        System.out.println(new Date());
    }

    static class MyFork extends RecursiveTask<Long> {

        long from, to;

        public MyFork(long from, long to) {
            this.from = from;
            this.to = to;
        }

        @Override
        protected Long compute() {
            //if operation is split into enough pieces
            //num of iteration <= num of processor's cores
            if ( (to - from) <= (numOfOperations / numOfCoresInProcessor) ) {
                //do operation
                long j = 0;
                for (long i = from; i < to; i++) {
                    j += i;
                }
                return j;
            }
            //else split into smallest pieces
            else {
                long middle = (to + from) / 2;
                MyFork firstHalf = new MyFork(from, middle);
                firstHalf.fork();
                MyFork secondHalf = new MyFork(middle+1, to);
                long secondValue = secondHalf.compute();
                return firstHalf.join() + secondValue;
            }

        }
    }

}
