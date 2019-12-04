package homework.ls_14_Set.maximum;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        List<Commodity> commodities = new LinkedList<>();



        while(true) {
            printMenu();
            System.out.print("choice: ");
            int ch = in.nextInt();
            Commodity commodity;
            int index;

            switch (ch) {
                case 1:
                    commodity = readCommodity();
                    commodities.add(commodity);

                    break;
                case 2:
                    System.out.println("\tDeleting element");
                    System.out.print("index: ");
                    index = in.nextInt();
                    commodities.remove(index);
                    break;
                case 3:

                    index = readIndex();
                    commodity = readCommodity();

                    commodities.set(index, commodity);

                    break;
                case 4:
                    System.out.println("sorting by name");
                    commodities.sort(Commodity.comparatorByName);
                    break;
                case 5:
                    System.out.println("sorting by length");
                    commodities.sort(Commodity.comparatorByLength);
                    break;
                case 6:
                    System.out.println("sorting by weight");
                    commodities.sort(Commodity.comparatorByWeight);
                    break;
                case 7:
                    System.out.println("sorting by height");
                    commodities.sort(Commodity.comparatorByHeight);
                    break;

                case 8:
                    index = readIndex();
                    System.out.println(commodities.get(index));
                    break;
                default:
                    System.exit(0);
            }
        }


    }

    private static void printMenu() {
        System.out.println("\t\tMenu");
        System.out.println("1. Add commodity");
        System.out.println("2. Remove commodity");
        System.out.println("3. Retain commodity");
        System.out.println("4. sort by name");
        System.out.println("5. sort by weight");
        System.out.println("6. sort by length");
        System.out.println("7. sort by height");
        System.out.println("else - exit");

    }

    private static Commodity readCommodity() {
        System.out.print("name: ");
        String name = in.next();
        System.out.print("weight: ");
        int weight = in.nextInt();
        System.out.print("height: ");
        int height = in.nextInt();
        System.out.print("length: ");
        int length = in.nextInt();

        return new Commodity(name, weight, length, height);
    }

    private static int readIndex() {
        System.out.println("\tRewrite element");
        System.out.print("index: ");
        return in.nextInt();
    }

}
