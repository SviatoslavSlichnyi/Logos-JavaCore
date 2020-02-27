package homework.ls_23_Streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorDemo {
    public static void main(String[] args) {
        Stream.of("one", "two", "three", "four").collect(Collectors.toCollection(ArrayList::new));
        Stream.of("one", "two", "three", "four").collect(Collectors.toCollection(TreeSet::new));

        Optional<Integer> collect1 = Stream.of(1, 2, 3, 4).collect(Collectors.maxBy(Integer::compareTo));
        Double collect = Stream.of(1, 3, 4, 5).collect(Collectors.averagingDouble(x -> x));

        Map<Boolean, List<Integer>> collect2 = Stream.of(1, 2, 3, 4).collect(Collectors.partitioningBy(x -> x < 2));
        Map<Boolean, List<Integer>> collect3 = Stream.of(1, 2, 3, 4).collect(Collectors.groupingBy(x -> x < 2));
        String collect4 = Stream.of("Jack", "is", "my", "friend")
                .collect(Collectors.joining(" ", "{", "}"));
        System.out.println(collect4);

        Map<Integer, Long> map = Stream.of(1, 2, 1, 3)
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));

    }
}
