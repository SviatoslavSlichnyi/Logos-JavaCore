package homework.ls_08_Enums_Scanner.task3;

import java.util.Scanner;

/**
 * Створити програму, яка буде обчислювати і виводити на екран суму двох цілих чисел, введених користувачем.
 * Якщо користувач некоректно введе хоча б одне з чисел, то повідомляти про помилку.
 */

public class Main {

    public static void main(String[] args) {

        System.out.print("a: ");
        int a = readNumber();

        System.out.print("b: ");
        int b = readNumber();

        System.out.println();

        int result = a + b;
        System.out.println("a + b = " + result);

    }

    private static int readNumber() {
        Scanner in = new Scanner(System.in);

        String line = in.nextLine();

        if(!isOnlyDigitNumber(line)) {
            throw new RuntimeException("Incorrect input");
        }

        return Integer.parseInt(line);
    }

    private static boolean isOnlyDigitNumber(String line) {
        return line.matches("\\d+");
    }

}
