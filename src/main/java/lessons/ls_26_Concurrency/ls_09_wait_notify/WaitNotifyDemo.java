package lessons.ls_26_Concurrency.ls_09_wait_notify;

public class WaitNotifyDemo {
    public static void main(String[] args) {
        Object obj = new Object();

        new Thread(() -> {
            synchronized (obj) {
                try {
                    System.out.println(Thread.currentThread().getName() + ": I am waiting....");
                    obj.wait();//Pause: current thread
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();

        new Thread(() -> {
            synchronized (obj) {
                System.out.println(Thread.currentThread().getName() + ": Hey, I am here, so you can continue.");
                obj.notify(); //Play: the previous thread
            }
        }).start();

    }
}
