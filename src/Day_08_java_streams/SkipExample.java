package Day_08_java_streams;

import java.util.List;

public class SkipExample {

    /*
            ----->  skip
            The **skip(n)** method skips the first n elements of the
            stream and processes the rest.

              ---- > LIMIT
             The limit(n) method in Java Streams is used to take
             only the first n elements of the stream.
     */

    public static void main(String[] args) {

        List<Integer> numbers = List.of(10, 20, 30, 40, 50);
        numbers.stream()
                .skip(2)
                .forEach(System.out::println);


        List<String> products = List.of("Pen", "Book", "Bag", "Phone");

        products.stream()
                .skip(2)
                .forEach(System.out::println);


        // limit
        List<Integer> data = List.of(1, 2, 3, 4, 5, 6, 7, 8);

        data.stream()
                .limit(5).forEach(System.out::println); // 1, 2, 3, 4, 5


        List<String> fruits = List.of("Apple", "Banana", "Mango", "Orange");

        fruits.stream()
                .limit(2)
                .forEach(System.out::println);


        // skip() + limit()

        data.stream()
                .skip(6) // begin form at index 4
//                .limit(data.getLast()) // stop last index or specified index ( 4 to 5, 2 to 7)
                .limit(2) // 7 , 8
                .forEach(System.out::println); // 8


    }
}
