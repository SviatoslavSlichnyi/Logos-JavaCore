package homework.ls_23_Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        //filter
        List<String> names = getNames();

        Stream<String> stream = names.stream();
        Stream<String> jack = stream.filter(name -> name.equalsIgnoreCase("jack"));
        long numOfJacks = jack.count();
        System.out.println(numOfJacks);

        //collect
        List<String> collect = names.stream()
                .filter(name -> name.charAt(0) == 'Z')
                .collect(Collectors.toList());
        collect.forEach(System.out::println);


        //map
        System.out.println("\nOnly Upper case names:");

        List<String> antherNames = getNames();
        List<Object> onlyUpperCase = antherNames.stream()
                .map(elem -> elem.toUpperCase())
                .collect(Collectors.toList());
        antherNames.forEach(System.out::println);
        System.out.println();
        onlyUpperCase.forEach(System.out::println);


        //flatMap
        System.out.println("\nMerge list by streams");
        List<String> mergeLists = Stream.of(Arrays.asList("one", "two", "three"), Arrays.asList("five", "seven", "ten"))
                .flatMap(x -> x.stream())
                .sorted()
                .collect(Collectors.toList());
        mergeLists.forEach(System.out::println);


        //min and max
        int minVal = Stream.of(5, 2, 6, 3, 7)
                .min(Comparator.comparing(x -> x))
                .get();

        int maxVal = Stream.of(5, 2, 6, 3, 7)
                .max(Integer::compareTo)
                .get();

        System.out.println("min: " + minVal);
        System.out.println("max: " + maxVal);

        //reduce
        int ac = Stream.of(1, 2, 3).reduce(0, (acc, element) -> acc + element);
        int accomulator = 0;
        for (int element : new int[]{1, 2, 3}) {
            accomulator += element;
        }
        System.out.println("accumulator: " + ac);

    }

    public static List<String> getNames() {
        List<String> names = new LinkedList<>();

        names.add("Jack");
        names.add("Sam");
        names.add("Sofia");
        names.add("Alex");
        names.add("Iona");
        names.add("Zorro");
        names.add("Zed");
        names.add("Kevin");

        return names;
    }

}
