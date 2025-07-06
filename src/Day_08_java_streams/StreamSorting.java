package Day_08_java_streams;

import java.util.Comparator;
import java.util.List;

public class StreamSorting {
    public static void main(String[] args) {

        /*

                In Java, if you want to sort elements of a collection
                using streams, you use the sorted() method.


         */

        //  1. Default Sorting (Natural Order)

        List<Integer> num = List.of(1, 4, 4, 5,2, 2, 3,0);
        num.stream().sorted().forEach(System.out::println);

        List<String> names = List.of("Zara", "Ayan", "Huzaifa");
        names.stream().sorted().forEach(System.out::println);

        //  2. Custom Sorting (Using Comparator)

        List<Integer> numbers = List.of(5, 2, 9, 1);
        numbers.stream().sorted(Comparator.reverseOrder())
                .forEach(System.out::println); // give me reverse order revers sorted

        //List<String> names = List.of("Zara", "Ayan", "Huzaifa");
        names.stream().sorted(Comparator.reverseOrder())
                .forEach(System.out::println); // Zara , Huzaifa ,Ayan



        //  3. Sort by Field (Object Property)
        List<Product> products = List.of(
                new Product("Laptop", 50000),
                new Product("Phone", 20000),
                new Product("Tablet", 30000)
        );
        System.out.println("Sort Products............... ");
        products.stream()
//                .sorted(Comparator.comparing(Product::getPrice))  // by price
//                .sorted(Comparator.comparing(Product::getName))  // by name
                .forEach(System.out::println);







    }
}

class Product {
    String name;
    int price;
    // constructor, getters


    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

