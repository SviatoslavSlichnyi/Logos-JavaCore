package lessons.ls8.enumdemo;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("Sara");
        person.setSex(Sex.FEMALE);

        System.out.println(person);


        System.out.println("Search: " + Sex.valueOf("FEMALE"));

        Sex[] sexes = Sex.values();
        for(Sex sex: sexes) {
            System.out.println(sex.name());
        }
        System.out.println(Arrays.toString(Sex.values()));


        //Are this enum before or after
        int compResult;
        compResult = Sex.MALE.compareTo(Sex.FEMALE);
        System.out.println(compResult);
        compResult = Sex.MALE.compareTo(Sex.MALE);
        System.out.println(compResult);
        compResult = Sex.FEMALE.compareTo(Sex.MALE);
        System.out.println(compResult + "");

        //find out index in enum list of items
        System.out.println(Sex.MALE.ordinal());

        /**
         * Collatoins
         * щоб задати за чим чортувати масив треба використовувати Comparable
         */


        System.out.println(Sex.FEMALE.getName());

        /**
         * 
         */

    }
}
