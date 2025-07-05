package Day_08_java_streams;

import java.util.List;

public class PeekExample {
    public static void main(String[] args) {

        List<Integer> num = List.of(3,4,5,6,7,8);
        final List<Integer> square = num.stream()
                .map(m ->  m * m)
//                .peek(System.out::println)
                .toList();

        List<String> names = List.of("abu", "huzaifa", "ali");

        names.stream()
                .map(m -> m.toUpperCase())
                .peek(System.out::println)
                .toList();

    }
}
