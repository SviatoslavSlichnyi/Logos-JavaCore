package homework.ls_08_Enums_Scanner.task1_Enums;

import homework.ls_08_Enums_Scanner.task1_Enums.year.Months;
import homework.ls_08_Enums_Scanner.task1_Enums.year.Seasons;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String text = readText();

        Months month = parseToMonth(text);

        printSameSeasonsAs(month);

        printSameAmountOfDaysAs(month);

        printMonthsWithLessDaysAs(month);

        printMonthsWithMoreDaysAs(month);

        printPreviousSeasonTo(month);

        printNextSeasonTo(month);

        printHasEvenAmountOfDays(month);


        System.out.println("---------------------------------------");


        printEvenMonths();

        printOddMonths();

    }

    private static String readText() {

        Scanner in = new Scanner(System.in);

        System.out.print("Write month: ");
        String text = in.next();

        return text;

    }

    //Перевірити чи є такий місяць (місяць вводимо з консолі, передбачити, щоб регістр букв був неважливим )
    private static Months parseToMonth(String text) {

        Months inputtedMonth = null;

        try {
            inputtedMonth = Months.valueOf(text.toUpperCase());
            System.out.println(text + " were found.");
        } catch (Exception e) {
            System.err.println(text + " are not exist in list of constants of Months.");
            e.printStackTrace();
        }

        System.out.println();

        return inputtedMonth;
    }

    //Вивести всі місяці з такою ж порою року
    private static void printSameSeasonsAs(Months month) {
        System.out.println("Months list in the same season:");

        Seasons currentSeason = month.getSeasons();

        for (Months m : Months.values()) {
            if(m.getSeasons().equals(currentSeason)) {
                System.out.println(m);
            }
        }

        System.out.println();
    }

    //Вивести всі місяці які мають таку саму кількість днів
    private static void printSameAmountOfDaysAs(Months month) {
        System.out.println("Months list which has the same amount of days:");

        int numOfDays = month.getDays();

        for (Months m : Months.values()) {
            if(m.getDays() == numOfDays) {
                System.out.println(m);
            }
        }

        System.out.println();
    }

    //Вивести на екран всі місяці які мають меншу кількість днів
    private static void printMonthsWithLessDaysAs(Months month) {
        System.out.println("Months list which has less days:");

        int numOfDays = month.getDays();

        for (Months m : Months.values()) {
            if(m.getDays() < numOfDays) {
                System.out.println(m);
            }
        }

        System.out.println();
    }

    //Вивести на екран всі місяці які мають більшу кількість днів
    private static void printMonthsWithMoreDaysAs(Months month) {
        System.out.println("Months list which has more days:");

        int numOfDays = month.getDays();

        for (Months m : Months.values()) {
            if(m.getDays() > numOfDays) {
                System.out.println(m);
            }
        }

        System.out.println();
    }

    //Вивести на екран наступну пору року
    private static void printPreviousSeasonTo(Months month) {
        //Вивести на екран попередню пору року
        System.out.print("The previous season is ");

        int currentSeasonPositionInArray = month.getSeasons().ordinal();
        int previousSeason = (currentSeasonPositionInArray - 1);
        if(previousSeason < 0) previousSeason += 4;

        System.out.println(Seasons.values()[previousSeason]);
    }

    //Вивести на екран наступну пору року
    private static void printNextSeasonTo(Months month) {
        System.out.print("The next season is ");

        int currentSeasonPositionInArray = month.getSeasons().ordinal();
        int nextSeason = (currentSeasonPositionInArray + 1) % 4;

        System.out.println(Seasons.values()[nextSeason]);
    }

    //Вивести на екран чи введений з консолі місяць має парну кількість днів
    private static void printHasEvenAmountOfDays(Months month) {
        if(isEven(month.getDays())) {
            System.out.println(month + " has even amount of days");
        } else {
            System.out.println(month + " has NOT even amount of days");
        }
    }

    //Вивести на екран всі місяці які мають парну кількість днів
    private static void printEvenMonths() {
        System.out.println("Months with even amount of day:");

        for(Months month: Months.values()) {
            if( (month.getDays() & 1) == 0) {
                System.out.println(month);
            }
        }

        System.out.println();
    }

    //Вивести на екран всі місяці які мають непарну кількість днів
    private static void printOddMonths() {
        System.out.println("Months with odd amount of day:");

        for(Months month: Months.values()) {
            if(isEven(month.getDays())) {
                System.out.println(month);
            }
        }

        System.out.println();
    }

    private static boolean isEven(int number) {
        return (number & 1) == 0;
    }

}
