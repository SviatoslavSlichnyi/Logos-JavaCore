package homework.ls_14_Set.mininal;

import java.util.*;

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

        print(students);

        Set<Student> sortedSet = new HashSet<>(students);
        System.out.println(sortedSet);

        print(sortedSet);


        students.sort(Student.comparator);
        print(students);

    }

    private static void print(Collection<Student> students) {
        System.out.println();
        System.out.println(students);
        System.out.println();
    }

}
