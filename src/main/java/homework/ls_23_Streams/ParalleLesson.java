package homework.ls_23_Streams;

import java.util.stream.Stream;

public class ParalleLesson {
    public static void main(String[] args) {
        Stream stream = Stream.of(1, 2).parallel(); 
    }
}
