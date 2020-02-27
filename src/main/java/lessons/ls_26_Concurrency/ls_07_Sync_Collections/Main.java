package lessons.ls_26_Concurrency.ls_07_Sync_Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * It is important to remember
 * that even if list is synchronized it still can be interrupted in our methods
 */

public class Main {
    public static void main(String[] args) {
        NameList nameList = new NameList();
        nameList.add("first");

        MyThread myThread = new MyThread(nameList);
        myThread.setName("one");
        myThread.start();

        new MyThread(nameList).start();
    }
}

class NameList {

    private List<String> list = Collections.synchronizedList(new ArrayList<>());

    public void add(String name) {
        list.add(name);
    }

    public synchronized String removeFirst() {
        if (list.size() > 0) {
            if (Thread.currentThread().getName().equals("one")) {
                Thread.yield();
            }
            return list.remove(0);
        }
        return null;
    }
}

class MyThread extends Thread {

    private NameList list;

    MyThread(NameList list) {
        this.list = list;
    }

    @Override
    public void run() {
        System.out.println(list.removeFirst());
    }
}