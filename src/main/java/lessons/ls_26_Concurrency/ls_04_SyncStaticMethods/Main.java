package lessons.ls_26_Concurrency.ls_04_SyncStaticMethods;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Resource.i = 5;

        MyThread myThread = new MyThread();
        myThread.setName("one");
        MyThread myThread2 = new MyThread();
        myThread2.setName("two");

        myThread.start();
        myThread2.start();

        myThread.join();
        myThread2.join();

        System.out.println(Resource.i);
    }
}

class Resource {

    static int i = 1;

    public  static void changeStaticI() {
        synchronized (Resource.class) {
            int i = Resource.i;

            if (Thread.currentThread().getName().equals("one")) {
                Thread.yield();
            }

            i++;
            Resource.i = i;
        }
    }

    public void changeI() {
        synchronized (this) {
            int i = Resource.i;

            if (Thread.currentThread().getName().equals("one")) {
                Thread.yield();
            }

            i++;
            Resource.i = i;
        }
    }

}

class MyThread extends Thread {

    /**
     * !!! Important
     * It is not recommended use static and non-static method at the same time.
     * That could make unexpected behaviour.
     */

    @Override
    public void run() {
        Resource.changeStaticI();
        new Resource().changeI();
    }
}