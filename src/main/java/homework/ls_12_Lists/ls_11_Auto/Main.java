package homework.ls_12_Lists.ls_11_Auto;

import homework.ls_12_Lists.ls_11_Auto.auto.Auto;
import homework.ls_12_Lists.ls_11_Auto.auto.Engine;
import homework.ls_12_Lists.ls_11_Auto.auto.Helm;
import homework.ls_12_Lists.ls_11_Auto.auto.Material;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        List<List<Auto>> autos = getRandomDoubleArrayOfAutos();

        printAutosArray(autos);

        System.out.println("\t\tAfter sorting");

        System.out.println("\nAscending (by power field):");
        sortByAscending(autos);
        printAutosArray(autos);


        System.out.println("\n\nDescending (by power field):");
        sortByDescending(autos);
        printAutosArray(autos);

    }

    private static List<List<Auto>> getRandomDoubleArrayOfAutos() {
        Random rand = new Random(47);
        final int randomRange = 90;

        final int SIZE1 = rand.nextInt(4) + 3;
        final int SIZE2 = rand.nextInt(4) + 3;
        List<List<Auto>> autos = new ArrayList<>(SIZE1);

        for (int i = 0; i < SIZE1; i++) {
            List<Auto> l = new ArrayList<>(SIZE2);
            for (int j = 0; j < SIZE2; j++) {
                int power = rand.nextInt(randomRange);
                int dayOfFirstRegistration = rand.nextInt(randomRange);
                int amountOfCylinders = rand.nextInt(randomRange);
                Engine engine = new Engine(amountOfCylinders);
                int diameter = rand.nextInt(randomRange);
                Helm helm = new Helm(diameter);
                int randomMaterial = rand.nextInt(2);
                Material material = Material.values()[randomMaterial];

                l.add(new Auto(power,dayOfFirstRegistration, engine, helm, material));
            }
            autos.add(l);
        }

        return autos;
    }

    private static void printAutosArray(List<List<Auto>> autos) {
        for (List<Auto> autosArray: autos) {
            for (Auto auto: autosArray) {
                System.out.println(auto);
            }
            System.out.println();
        }
    }

    private static void sortByAscending(List<List<Auto>> autos) {
        for (List<Auto> autosList: autos) {
            autosList.sort(Auto.comparatorAscending);
        }
    }

    private static void sortByDescending(List<List<Auto>> autos) {
        for (List<Auto> autosList: autos) {
            autosList.sort(Auto.comparatorDescending);
        }
    }

}
