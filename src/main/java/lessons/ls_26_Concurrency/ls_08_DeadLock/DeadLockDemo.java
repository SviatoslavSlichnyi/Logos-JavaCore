package lessons.ls_26_Concurrency.ls_08_DeadLock;

/**
 *  DeadLock is logic mistake.
 *  Happened when it was called from one sync method to other sync method
 *  where we again call to the first method which is finished.
 */

public class DeadLockDemo {
    public static void main(String[] args) {
        RecourseA recourseA = new RecourseA();
        RecourseB recourseB = new RecourseB();

        MyThreadA myThreadA = new MyThreadA(recourseA);
        MyThreadB myThreadB = new MyThreadB(recourseB);

        myThreadA.start();
        myThreadB.start();

        Object obj = new Object();
    }
}


class RecourseA {

    private RecourseB recourseB;

    public synchronized int getI() {
        return recourseB.returnI();
    }

    public synchronized int returnI() {
        return 1;
    }

}

class RecourseB {

    private RecourseA recourseA;

    public synchronized int getI() {
        return recourseA.returnI();
    }

    public synchronized int returnI() {
        return 1;
    }

}


class MyThreadA extends Thread {
    RecourseA recourseA;

    MyThreadA(RecourseA recourseA) {
        this.recourseA = recourseA;
    }

    @Override
    public void run() {
        System.out.println(recourseA.getI());
    }
}


class MyThreadB extends Thread {
    RecourseB recourseB;


    MyThreadB(RecourseB recourseB) {
        this.recourseB = recourseB;
    }

    @Override
    public void run() {
        System.out.println(recourseB.getI());
    }
}