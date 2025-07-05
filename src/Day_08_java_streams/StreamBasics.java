package Day_08_java_streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class StreamBasics {

    public static void main(String[] args) {

        // How to Create a Stream


        // ex - 1 Array
        String [] names = {"Hasan","Ali", "Ahamad","Mohammd"};
        Stream<String> stringStream = Arrays.stream(names);
        stringStream.forEach(System.out::println);


        // ex - 2 List
        List<String> fruits = List.of("mango", "apple", "banana", "orange");
        Stream<String> intoStream = fruits.stream(); // converted into stream
        fruits.forEach(System.out::println);

        // Numbers
        int[] nums = {1, 2, 3};
        IntStream intStream = Arrays.stream(nums);
        intStream.forEach(System.out::println);

        char[] ch = {'a', 'b', 'f', 'r'};
        Stream.Builder<Character> characterBuilder = Stream.builder();
        for (char cha : ch){
            characterBuilder.add(cha);
        }
        Stream<Character> characterStream  = characterBuilder.build();
        characterStream.forEach(System.out::println);




    }

}
