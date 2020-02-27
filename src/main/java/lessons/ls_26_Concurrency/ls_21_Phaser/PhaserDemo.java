package lessons.ls_26_Concurrency.ls_21_Phaser;

import java.util.concurrent.Phaser;

/**
 *  Each of worker to do some job.
 *  The new car can be taken only when each worker finished his work.
 *  Example: Cars Washer
 */

public class PhaserDemo {
    public static void main(String[] args) {
        //We have to wait for two threads
        Phaser phaser = new Phaser(2);
        new Washer(phaser);
        new Washer(phaser);
    }

    static class Washer extends Thread {
        Phaser phaser;

        Washer(Phaser phaser) {
            this.phaser = phaser;
            start();
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println(getName() + " washing the car");
                /**
                 *  when all thread call this method
                 *  we can not continue
                 */
                phaser.arriveAndAwaitAdvance();
            }
        }
    }

}
