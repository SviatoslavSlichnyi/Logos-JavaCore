package homework.ls_25_mehod_reference;

import homework.ls_14_Set.mininal.Student;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream.of("one", "two", "three").map(x -> x.toUpperCase());
        Stream.of("one", "two", "three").map(String::toUpperCase);

        Stream.of(new Runner("Jone"), new Runner("Sammy")).map(Runner::getName).forEach(System.out::println);
        Stream.of("Jone", "Sammy").map(Runner::new).map(Runner::getName).forEach(System.out::println);
    }

}

class Runner {

    private String name;

    public Runner(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
