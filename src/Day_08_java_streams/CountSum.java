package Day_08_java_streams;

import java.util.List;

public class CountSum {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(5, 3, 8, 2, 9);
        Long count = numbers.stream().count();
        System.out.println(count);

        Integer sum = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(sum);
    }
}
