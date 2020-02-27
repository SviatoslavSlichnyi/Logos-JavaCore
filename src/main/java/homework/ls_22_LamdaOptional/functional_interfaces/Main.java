package homework.ls_22_LamdaOptional.functional_interfaces;

import java.util.Random;
import java.util.function.*;


//        Consumer<Integer> consumer = x -> System.out.println(x);  //accept()
//        Supplier<Integer> supplier = () -> new Integer(5);        //get();
//        Predicate<Integer> predicate = x -> x > 5;                //test();
//        Function<Integer, String> function = x -> x.toString();   //apply();
//        UnaryOperator<Integer> unaryOperator = x -> x * x;        //apply()
//        BinaryOperator<Integer> binaryOperator = (x, y) -> x * y; //apply()


public class Main {
    public static void main(String[] args) {

        //-------------------------------------------------------------------------------------------------
        //void
        Consumer<Integer> consumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        };
        Consumer<Integer> consumerLamda = x -> System.out.println(x + " is number.");

        consumer.accept(10);



        //-------------------------------------------------------------------------------------------------
        //<Output type>
        Supplier<Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return new Random().nextInt();
            }
        };
        Supplier<Integer> supplierLamda = () -> new Random().nextInt();

        Integer sup = supplier.get();



        //-------------------------------------------------------------------------------------------------
        //boolean
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer >= 0;
            }
        };
        Predicate<Integer> predicateLamda = x -> x >= 0;

        boolean answer = predicate.test(5);
        System.out.println(answer);



        //-------------------------------------------------------------------------------------------------
        //<Input type, Output type>
        Function<Integer, String> function = new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                return integer.toString() + " was gotten from Function";
            }
        };
        Function<Integer, String> functionLamda = x -> String.valueOf(x);

        String returnType = function.apply(100);



        //-------------------------------------------------------------------------------------------------
        //<Input and Output type at the same time>
        UnaryOperator<Integer> unaryOperator = new UnaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer;
            }
        };
        UnaryOperator<Integer> unaryOperatorLamda = x -> x;

        Integer num = unaryOperator.apply(100);



        //-------------------------------------------------------------------------------------------------
        //Type
        BinaryOperator<Integer> binaryOperator = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        };
        BinaryOperator<Integer> binaryOperatorLamda = (x,y) -> x * y;

        Integer sum = binaryOperator.apply(1, 2);

    }
}
