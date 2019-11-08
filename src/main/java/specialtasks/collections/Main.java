package specialtasks.collections;

import specialtasks.collections.hashMap.MyDate;
import specialtasks.collections.hashMap.MyHashMap;
import specialtasks.collections.list.MyLinkedList;
import specialtasks.collections.list.MyList;

public class Main {

    public static void printMyList(MyList list) {
        //print the list
        System.out.print("list: ");
        for(int i = 0; i < list.size(); i++)
            System.out.print(list.get(i) + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        /*************MyLinkedList Testing***************/
        MyList list = new MyLinkedList();

        final int size = 10;

        //fill the list with numbers from 1 to 10
        for(int i = 0; i < size; i++)
            list.add(i+1);


        printMyList(list);

        //in place after index 1 insert element: 33
        list.add(2, 33);
        //rewrite element with index 4 into value to 55
        list.set(4, 55);

        printMyList(list);

        for(int i = 0, n = list.size(); i < n; i++)
            list.remove(0);

        System.out.print("after deleting: ");
        printMyList(list);

        System.out.println();
        //fill the list with numbers from 1 to 10
        for(int i = 0; i < size; i++)
            list.add(i+1);

        printMyList(list);

        while (list.size() != 0) {
            list.remove(list.size()-1);
        }

        System.out.print("deleting from back: ");
        printMyList(list);


        System.out.println();
        //fill the list with numbers from 1 to 10
        for(int i = 0; i < size; i++)
            list.add(i+1);
        printMyList(list);

        list.remove(3);
        list.remove(list.size()-2);

        System.out.print("deleting from middle 2-nd and size-2: ");
        printMyList(list);


        System.out.println();
        list.clear();
        System.out.print("after cleaning: ");
        printMyList(list);


        System.out.println();
        System.out.println("Output an exception: ");
        //exception
        list.get(Integer.MIN_VALUE);

        /**************************MAPS********************************/

        MyHashMap myMap = new MyHashMap();
        myMap.put(new MyDate("15.05.1999"), "Bob");
        myMap.put(new MyDate("20.11.1993"), "Jake");
        myMap.put(new MyDate("25.12.1986"), "Sam");

        myMap.put(new MyDate("20.03.2009"), "Elvis");
        myMap.put(new MyDate("25.04.2001"), "Steve");

        System.out.println(myMap.get(new MyDate("15.05.1999")));
        System.out.println(myMap.get(new MyDate("20.11.1993")));
        System.out.println(myMap.get(new MyDate("25.12.1986")));

        System.out.println(myMap.get(new MyDate("20.03.2009")));
        System.out.println(myMap.get(new MyDate("25.04.2001")));
    }
}
