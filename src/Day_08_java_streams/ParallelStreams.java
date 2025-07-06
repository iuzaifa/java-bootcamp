package Day_08_java_streams;

import java.util.List;
import java.util.stream.Stream;

public class ParallelStreams {


    /**

         Parallel Stream allows you to process data using multiple threads — speeding up operations
         on large collections by splitting tasks across CPU cores.


     */
    public static void main(String[] args) {



        Long start = System.currentTimeMillis();

        List<Integer> list = Stream.iterate( 1,x -> x + 1).limit(20000).toList();
        List<Long> factorials = list.stream().map(ParallelStreams::factorial).toList();
        Long end = System.currentTimeMillis();
        System.out.println("Actual Sequential Time : "+ (end - start) + "ms");



        start = System.currentTimeMillis();
        factorials = list.parallelStream().map(ParallelStreams::factorial).toList();

        end = System.currentTimeMillis();
        System.out.println("Actual Parallel Time : "+ (end - start) + "ms");


    }

    public static long factorial(int n){
        long fact = 1;
        for (int i = 2; i <= n; i++) fact *= i;
        return fact;
    }

}
