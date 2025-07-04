package Day_08_java_streams.filterMapReduce;

import java.util.Arrays;
import java.util.List;

public class Reduce {
    public static void main(String[] args) {
//        List<Integer> nums = List.of(1, 2, 3, 4);
//
//        int sum =  nums.stream().reduce(0, (a , b) -> a+b);
//        System.out.println(sum);



        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.stream().reduce(0, Integer::sum);
        int reverse = numbers.stream()
                .reduce(0, Integer::min);

        System.out.println(sum);

    }
}
