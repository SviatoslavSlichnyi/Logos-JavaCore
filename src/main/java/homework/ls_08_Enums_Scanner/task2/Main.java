package homework.ls_08_Enums_Scanner.task2;

import java.util.Scanner;

/**
 * ворити програму, яка буде повідомляти,
 * чи є ціле число, введене користувачем, парним або непарним.
 * Якщо користувач введе не ціла число, то повідомляти йому про помилку.
 */

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("Number: ");

        String line = null;
        if(in.hasNextLine()) {
            line = in.nextLine();
        }

        in.close();


        if(line == null) {
            throw new NullPointerException();
        }


        if(!isOnlyDigitNumber(line)) {
            throw new RuntimeException("Incorrect input");
        }


        int number = Integer.parseInt(line);

        if(isEven(number)) {
            System.out.println(number + " is even.");
        } else {
            System.out.println(number + " is odd.");
        }

    }

    public static boolean isOnlyDigitNumber(String line) {
        return line.matches("\\d+");
    }

    public static boolean isEven(int number) {
        return (number & 1) == 0;
    }

}
