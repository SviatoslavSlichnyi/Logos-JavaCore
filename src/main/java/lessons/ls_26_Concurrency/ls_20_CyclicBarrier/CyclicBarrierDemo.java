package lessons.ls_26_Concurrency.ls_20_CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 *  When it is needed to run a thread only when another number of threads to be waiting (await())
 *
 *  Example: Only when runners are ready we start the running competition.
 */

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        int numberOfThreadsToBeReady = 3;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(numberOfThreadsToBeReady, new Run());

        for (int i = 0; i < numberOfThreadsToBeReady; i++) {
            new Sportsman(cyclicBarrier);
        }
    }

     static class Run extends Thread {
         @Override
         public void run() {
             System.out.println("Run is begun");
         }
     }

     static class Sportsman extends Thread {
        CyclicBarrier barrier;

        public Sportsman(CyclicBarrier barrier) {
            this.barrier = barrier;
            start();
        }

         @Override
         public void run() {
             try {
                 System.out.println(this.getName() + " - starts");
                 barrier.await();
             } catch (InterruptedException | BrokenBarrierException e) {
                 e.printStackTrace();
             }
         }
     }

}


