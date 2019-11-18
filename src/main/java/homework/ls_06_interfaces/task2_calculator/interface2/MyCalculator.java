package homework.ls_06_interfaces.task2_calculator.interface2;


import homework.ls_06_interfaces.task2_calculator.interface1.Numberable;

public class MyCalculator implements Numberable {

    @Override
    public double div(double a, double b) {

        if(b == 0) {
            throw new ArithmeticException("divide by zero");
        }

        return a / b;
    }

    @Override
    public double sub(double a, double b) {
        return a - b;
    }

    @Override
    public double mult(double a, double b) {
        return a * b;
    }

    @Override
    public double add(double a, double b) {
        return a + b;
    }
}
