package homework.ls_01_Primitives;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        boolean b = true;
        byte byt = 120;
        short sh = 40;
        int ii = 1;
        long l = 15L;
        double db = 1514514;
        float fl = 12341234F;

        System.out.println("byte max: " + Integer.MAX_VALUE);
        System.out.println("Short max: " + Short.MAX_VALUE);
        System.out.println("Integer max: " + Integer.MAX_VALUE);
        System.out.println("Long max: " + Long.MAX_VALUE);
        System.out.println("Double max: " + Double.MAX_VALUE);
        System.out.println("Float max: " + Float.MAX_VALUE);

        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

        System.out.println(Arrays.toString(arr));

        int min = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] < min) {
                min = arr[i];
            }
        }

        System.out.println("min: " + min);

        int max = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] < max) {
                max = arr[i];
            }
        }

        System.out.println("max: " + max);

    }
}
