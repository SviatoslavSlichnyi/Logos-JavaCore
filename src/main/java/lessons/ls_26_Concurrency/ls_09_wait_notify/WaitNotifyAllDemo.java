package lessons.ls_26_Concurrency.ls_09_wait_notify;

public class WaitNotifyAllDemo {
    public static void main(String[] args) {
        Object obj = new Object();

        new Thread(() -> {
            synchronized (obj) {
                try {
                    System.out.println(Thread.currentThread().getName() + ": I am waiting....");
                    obj.wait();//Pause #1
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (obj) {
                try {
                    System.out.println(Thread.currentThread().getName() + ": I am waiting....");
                    obj.wait();//Pause #2
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();




        new Thread(() -> {
            synchronized (obj) {
                System.out.println(Thread.currentThread().getName() + ": Hey, I am here, so you can continue.");
                obj.notifyAll();//Play All: play #1, play #2, ...
                //Turn wait off from all waiting thread which are connected with obj reference
            }
        }).start();

    }
}
