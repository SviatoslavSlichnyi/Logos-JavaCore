package homework.ls_14_Set.mininal;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Student s1 = new Student("Alert", 20);
        Student s2 = new Student("Simsons", 17);
        Student s3 = new Student("Carl", 21);
        Student s4 = new Student("Steve", 18);

        List<Student> students = new LinkedList<>();

        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);

        printList(students);

        Set<Student> sortedSet = new HashSet<>(students);
        System.out.println(sortedSet);

        printSet(sortedSet);


        students.sort(Student.comparator);
        printList(students);

    }

    private static void printList(List<Student> students) {
        System.out.println();
        System.out.println(students);
        System.out.println();
    }

    private static void printSet(Set<Student> students) {
        System.out.println();
        System.out.println(students);
        System.out.println();
    }

}
