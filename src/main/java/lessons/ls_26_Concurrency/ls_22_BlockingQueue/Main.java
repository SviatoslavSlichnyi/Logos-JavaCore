package lessons.ls_26_Concurrency.ls_22_BlockingQueue;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 *
 */

public class Main {
    public static void main(String[] args) {
        //Can produce an error
//        Queue<String> queue = new PriorityQueue<>();
//
//        new Thread(() -> System.out.println(queue.remove())).start();
//
//        new Thread(() -> queue.add("this is string")).start();


        //for now that is save for working with queue
        BlockingQueue<String> queue = new PriorityBlockingQueue<>();

        new Thread(() -> {
            try {
                System.out.println(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> queue.add("this is string")).start();


    }
}
