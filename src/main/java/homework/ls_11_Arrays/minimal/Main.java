package homework.ls_11_Arrays.minimal;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Integer[] numbers = getRandomArray(10);

        System.out.println("array: " + Arrays.toString(numbers));

        Integer[] increase = numbers.clone();
        Integer[] decrease = numbers.clone();

        Arrays.sort(increase);
        Arrays.sort(decrease, Collections.reverseOrder());

        System.out.println("After sorting....");
        System.out.println("increasing: " + Arrays.toString(increase));
        System.out.println("decreasing: " + Arrays.toString(decrease));


    }

    private static Integer[] getRandomArray(final int LENGTH) {
        Random rand = new Random(47);

        Integer[] numbers = new Integer[LENGTH];
        for (int i = 0; i < numbers.length; i++) {
            int randomNumber = 1 + rand.nextInt(10);
            numbers[i] = randomNumber;
        }

        return numbers;
    }

}
