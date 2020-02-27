package lessons.ls_26_Concurrency.ls_01_CreateThread;

public class Main {
    public static void main(String[] args) {

        //#1 way to create Thread
        MyThread myThread = new MyThread();
        myThread.start();


        //#2 way to create Thread
        MyRunnable myRunnable = new MyRunnable();
        Thread myRunnableThread = new Thread(myRunnable);
        myRunnableThread.start();

    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("It is a MyThread");
    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("It is a MyRunnable");
    }
}