package homework.ls_06_interfaces.task2;

import homework.ls_06_interfaces.task2.interface2.MyCalculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        MyCalculator calc = new MyCalculator();

        System.out.print("a: ");
        int a = readNumber();

        System.out.print("b: ");
        int b = readNumber();

        System.out.println();
        System.out.println("\tChoose operation:");
        System.out.println("1. +");
        System.out.println("2. -");
        System.out.println("3. *");
        System.out.println("4. /");
        System.out.print("choice: ");
        int ch = readNumber();

        if(ch == 1) {
            System.out.println("a + b = " + calc.add(a, b));
        }
        else if(ch == 2) {
            System.out.println("a - b = " + calc.sub(a, b));
        }
        else if(ch == 3) {
            System.out.println("a * b = " + calc.mult(a, b));
        }
        else if(ch == 4) {
            System.out.println("a / b = " + calc.div(a, b));
        }

    }

    public static int readNumber() {

        Scanner in = new Scanner(System.in);

        String line = null;

        if(in.hasNextLine()) {
            line = in.nextLine();
        }


        if(line == null) {
            throw new NullPointerException();
        }


        if(!isOnlyDigitNumber(line)) {
            throw new RuntimeException("Incorrect input");
        }


        return Integer.parseInt(line);
    }

    public static boolean isOnlyDigitNumber(String line) {
        return line.matches("\\d+");
    }

}
