package homework.ls_06_interfaces.task2;

import homework.ls_06_interfaces.task2.interface2.MyCalculator;

public class Main {
    public static void main(String[] args) {

        MyCalculator calc = new MyCalculator();

        System.out.println("2 + 2 = " + calc.add(2, 2));
        System.out.println("10 - 2 = " + calc.sub(10, 2));
        System.out.println("10 * 10 = " + calc.mult(10, 10));
        System.out.println("50 / 2 = " + calc.div(50, 2));

    }
}
