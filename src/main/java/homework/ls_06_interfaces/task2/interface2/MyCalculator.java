package homework.ls_06_interfaces.task2.interface2;


import homework.ls_06_interfaces.task2.interface1.Numberable;

public class MyCalculator implements Numberable {

    @Override
    public int div(int a, int b) {

        if(b == 0) {
            throw new ArithmeticException("divide by zero");
        }

        return a / b;
    }

    @Override
    public int sub(int a, int b) {
        return a - b;
    }

    @Override
    public int mult(int a, int b) {
        return a * b;
    }

    @Override
    public int add(int a, int b) {
        return a + b;
    }
}
