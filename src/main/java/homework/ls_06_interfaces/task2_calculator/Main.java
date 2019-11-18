package homework.ls_06_interfaces.task2_calculator;

import homework.ls_06_interfaces.task2_calculator.interface2.MyCalculator;

import java.util.Scanner;

public class Main {

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        MyCalculator calc = new MyCalculator();

        System.out.print("a: ");
        double a = in.nextDouble();

        System.out.print("b: ");
        double b = in.nextDouble();

        System.out.println();
        System.out.println("\tChoose operation:");
        System.out.println("1. +");
        System.out.println("2. -");
        System.out.println("3. *");
        System.out.println("4. /");
        System.out.print("choice: ");
        int ch = in.nextInt();

        if (ch == 1) {
            System.out.println("a + b = " + calc.add(a, b));
        } else if (ch == 2) {
            System.out.println("a - b = " + calc.sub(a, b));
        } else if (ch == 3) {
            System.out.println("a * b = " + calc.mult(a, b));
        } else if (ch == 4) {
            System.out.println("a / b = " + calc.div(a, b));
        }

    }

}
