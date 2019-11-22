package homework.ls_11_Arrays.maximal;

import homework.ls_11_Arrays.maximal.auto.Auto;
import homework.ls_11_Arrays.maximal.auto.Engine;
import homework.ls_11_Arrays.maximal.auto.Helm;
import homework.ls_11_Arrays.maximal.auto.Material;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Auto[][] autos = getRandomDoubleArrayOfAutos();

        printAutosArray(autos);

        int fillArrayWith = 0;
        Auto auto = new Auto(0,0, new Engine(0), new Helm(0), Material.SKIN);
        Arrays.fill(autos[fillArrayWith], auto);

        System.out.println("\t\tAfter sorting");

        System.out.println("\nAscending (by power field):");
        sortByAscending(autos);
        printAutosArray(autos);


        System.out.println("\n\nDescending (by power field):");
        sortByDescending(autos);
        printAutosArray(autos);

    }

    private static Auto[][] getRandomDoubleArrayOfAutos() {
        Random rand = new Random(47);
        final int randomRange = 90;

        final int SIZE1 = rand.nextInt(4) + 3;
        final int SIZE2 = rand.nextInt(4) + 3;
        Auto[][] autos = new Auto[SIZE1][SIZE2];

        for (int i = 0; i < autos.length; i++) {
            for (int j = 0; j < autos[i].length; j++) {
                int power = rand.nextInt(randomRange);
                int dayOfFirstRegistration = rand.nextInt(randomRange);
                int amountOfCylinders = rand.nextInt(randomRange);
                Engine engine = new Engine(amountOfCylinders);
                int diameter = rand.nextInt(randomRange);
                Helm helm = new Helm(diameter);
                int randomMaterial = rand.nextInt(2);
                Material material = Material.values()[randomMaterial];

                autos[i][j] = new Auto(power,dayOfFirstRegistration, engine, helm, material);
            }
        }

        return autos;
    }

    private static void printAutosArray(Auto[][] autos) {
        for (Auto[] autosArray: autos) {
            for (Auto auto: autosArray) {
                System.out.println(auto);
            }
            System.out.println();
        }
    }

    private static void sort(Auto[][] autos) {
        for (Auto[] autosArray: autos) {
            Arrays.sort(autosArray);
        }
    }

    private static void sortByAscending(Auto[][] autos) {
        for (Auto[] autosArray: autos) {
            Arrays.sort(autosArray, Auto.comparatorAscending);
        }
    }

    private static void sortByDescending(Auto[][] autos) {
        for (Auto[] autosArray: autos) {
            Arrays.sort(autosArray, Auto.comparatorDescending);
        }
    }

}
