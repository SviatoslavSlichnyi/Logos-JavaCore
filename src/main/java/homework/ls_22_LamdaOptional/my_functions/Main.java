package homework.ls_22_LamdaOptional.my_functions;

public class Main {
    public static void main(String[] args) {
        MyConsumer<String> greeting = name -> System.out.println("Hello, " + name);
        greeting.accept("Mike\n");

        justDoIt(str -> {
            System.out.println(str);
        });
    }

    public static void justDoIt(MyConsumer<String> func) {
        for (int i = 0; i < 3; i++) {
            func.accept("Hello World");
        }
    }

}
