package Day_08_java_streams.filterMapReduce;


import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Filter {

    public static void main(String[] args) {

        /*

            SYNTAX OF FILTER STREAM
            list.stream().filter(element -> condition).collect(Collectors.toList());

            Generic Stream Filter Syntax
            List<T> result = list.stream().filter(element -> condition).collect(Collectors.toList());

            - List<T>	A list of elements of type T (generic type)
            - list.stream()	Converts the list into a stream
            - .filter(element -> ...)	Filters elements based on a boolean condition
            - collect(Collectors.toList())	Collects the filtered stream back into a List

         */


        // Convert array to Stream like , Strings, Integer, Double..... All
        int [] nums = {5,4,5,6,7,8,9,9,8,7,6,5}; // Step 1: Define an int array
        final IntStream intStream = Arrays.stream(nums); // Step 2: Convert the array into an IntStream
        System.out.println("basic understanding streams"); // Step 3: Just a console prompt
        intStream.forEach(System.out::println); // Step 4: Print each element using the stream




        // ex - 1
        List<Integer> numbers = List.of(3,4,5,6,7,8,9,9,8,7,6,5);
        List<String> name = List.of("aman", "uzaifa", "ubaid", "salim", "ilham");
        List<Boolean> booleans = List.of(true, true , false, true, true , false ,true, true , false);


        List<Integer> list = numbers.stream().filter(n -> n % 2 == 0).toList();
        System.out.println("even numbers : " + list);

        List<Integer> lessThan5 = numbers.stream().filter(n -> n <= 5).toList();
//        System.out.println("less than 5: "+ lessThan5 );
        lessThan5.forEach(System.out::println);

        List<String> names = name.stream().filter(nm -> nm.startsWith("u")).toList();
//        System.out.println(" Start with u names :" + names);
        names.forEach(System.out::println);


        List<Boolean> getTrue = booleans.stream().filter(b -> b).toList();
        System.out.println("True :" + getTrue );

    }
}

