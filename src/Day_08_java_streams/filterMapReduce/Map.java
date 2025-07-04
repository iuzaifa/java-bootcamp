package Day_08_java_streams.filterMapReduce;

import java.util.Arrays;
import java.util.List;

public class Map {

    public static void main(String[] args) {

//        <R> Stream<R> map(Function<? super T, ? extends R> mapper)


        List<String> words = Arrays.asList("hello", "world", "java", "streams");

        List<String> uppercaseWords = words.stream()
                .map(String::toUpperCase)
                .toList();
        System.out.println("Uppercase Words : " + uppercaseWords);


        words.stream()
                .map(String::length)
                .toList()
                .forEach(System.out::println);



    }
}
