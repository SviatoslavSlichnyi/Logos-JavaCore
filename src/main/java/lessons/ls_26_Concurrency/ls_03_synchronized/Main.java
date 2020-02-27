package lessons.ls_26_Concurrency.ls_03_synchronized;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Resource resource = new Resource();
        resource.setI(5);

        MyThread thread_1 = new MyThread(resource);
        MyThread thread_2 = new MyThread(resource);

        thread_1.start();
        thread_2.start();

        thread_1.join();
        thread_2.join();

        System.out.println(resource.getI());

    }
}

class MyThread  extends Thread {

    private Resource resource;

    public MyThread(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {

    }
}

class Resource {
    private int i;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    //synchronized - do this method by the end and only after done it go to another thread
    public synchronized void changeI() {
        int tempI = this.i;

        if (Thread.currentThread().getName().equals("one")) {
            Thread.yield();
        }

        tempI++;
        this.i = tempI;
    }
}