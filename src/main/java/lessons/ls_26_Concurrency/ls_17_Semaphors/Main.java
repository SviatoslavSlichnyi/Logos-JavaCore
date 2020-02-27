package lessons.ls_26_Concurrency.ls_17_Semaphors;

import java.util.concurrent.Semaphore;

/**
 *  Senofors like tables in restaurant.
 *  Tables are resources.
 *  Visitors are threads.
 *  Thread ask a table, and when some table becomes free,
 *  The thread can take it.
 *
 *  We can set up the number of thread to be execute at the same time.
 */

public class Main {
    public static void main(String[] args) {
        Semaphore table = new Semaphore(2);

        Person person1 = new Person();
        Person person2 = new Person();
        Person person3 = new Person();
        Person person4 = new Person();
        Person person5 = new Person();
        Person person6 = new Person();
        Person person7 = new Person();

        person1.setTable(table);
        person2.setTable(table);
        person3.setTable(table);
        person4.setTable(table);
        person5.setTable(table);
        person6.setTable(table);
        person7.setTable(table);

        person1.start();
        person2.start();
        person3.start();
        person4.start();
        person5.start();
        person6.start();
        person7.start();

    }
}

class Person extends Thread {
    Semaphore table;

    public void setTable(Semaphore table) {
        this.table = table;
    }

    @Override
    public void run() {
        System.out.println(this.getName() + " wasting for table");

        try {
            table.acquire();
            System.out.println(this.getName() + " eat at the table");
            this.sleep(1_000);
            System.out.println(this.getName() + " release table");
            table.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}