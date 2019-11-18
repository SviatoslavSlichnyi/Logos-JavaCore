package homework.ls_09_Exceptions.task2_MyException;

public class Methods {

    public static double add(double a, double b) throws IllegalAccessException {

        if(a < 0 && b < 0) {
            throw new IllegalArgumentException();
        } else if(a > 0 && b > 0) {
            throw new MyException("a > 0 and b > 0");
        }

        return 0;
    }

    public static double sub(double a, double b) {
        if(a == 0 && b != 0) {
            throw new ArithmeticException();
        }

        return 0;
    }

    public static double mult(double a, double b) {
        if(a != 0 && b == 0) {
            throw new ArithmeticException();
        }

        return 0;
    }

    public static double div(double a, double b) throws IllegalAccessException {
        if(a == 0 && b == 0) {
            throw new IllegalAccessException();
        }

        return 0;
    }



}
