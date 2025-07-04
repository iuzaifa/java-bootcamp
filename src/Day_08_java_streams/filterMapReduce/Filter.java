package Day_08_java_streams.filterMapReduce;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Filter {

    public static void main(String[] args) {

        // Stream<T> filter(Predicate<? super T> predicate)


        // Print names that start with the given letter(A to Z, a to z ) (Desire name or letters)
        List<String> names = Arrays.asList(
                "Alice", "Bob", "Anna", "Charlie", "David"
        );
        List<String> filteredNames = names.stream()
                .filter(name -> name.startsWith("Alice"))
//                .toList();
                .collect(Collectors.toList());
        System.out.println(filteredNames);






        // Check even numbers
        List<Integer> nums = List.of(10, 15, 20, 25, 30);
        nums.stream()
                .filter(n-> n % 2 == 0)
                .forEach(System.out::println);



        // Print marks that are less than 23
        List<Integer> marks = List.of(23, 45,67,89,90,78,56,32,12,34,23,12);
        marks.stream()
                .filter(n -> n < 23)
                .forEach(System.out::println);





    }
}
