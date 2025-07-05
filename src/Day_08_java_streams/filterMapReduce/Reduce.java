package Day_08_java_streams.filterMapReduce;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Reduce {
    public static void main(String[] args) {


        /*
            The reduce() method is used to reduce the elements of a stream to a single value
            using a binary operation (like sum, multiply, min, etc.).

                            SYNTAX
            Optional<T> reduce(BinaryOperator<T> accumulator)
            T reduce(T identity, BinaryOperator<T> accumulator)
            <U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner)


                                Examples

         */



        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6,7,8,4,3,3);
        int sum = numbers.stream()
                .reduce(0, (a,b) -> a + b);
                // product .reduce(1, (a, b) -> a * b);
        System.out.println(sum);


        // Find Longest String
        List<String> words = List.of("java", "streams", "rocks", "mango", "pineapple","apple", "banana", "orange");
        String longestStr = words.stream()
                .reduce((a, b) -> a.length() > b.length() ? a : b)
                .orElse("");
        System.out.println("longestStr : " + longestStr);


        //  Concatenate Strings
        List<String> concat = List.of("Abu", "Huzaifa");
        String fullname = concat.stream()
                .reduce("", (a, b)-> a +  " " + b);
        System.out.println("Fullname :" + fullname);


        //  Without Initial Value (
        // List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6,7,8,4,3,3);
        Optional<Integer> max = numbers.stream()
                .reduce((a, b) -> a > b ? a : b);
        max.ifPresent(System.out::println);







    }
}
