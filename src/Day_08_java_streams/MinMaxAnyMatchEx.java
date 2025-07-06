package Day_08_java_streams;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class MinMaxAnyMatchEx {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(5, 3, 9);

        boolean isMatched = numbers.stream().anyMatch(n -> n % 2 == 0);
        System.out.println(isMatched);




        Optional<Integer> min_max =
                //numbers.stream().min(Integer::compareTo);
                numbers.stream().max(Integer::compareTo);
        //min_max.ifPresent(m -> System.out.println("Min : " + m));
        min_max.ifPresent(m -> System.out.println("max : "+ m));

        List<Stationary> stationary = List.of(
                new Stationary("Pen", 10),
                new Stationary("Book", 50),
                new Stationary("Laptop", 500)
        );

        Optional<Stationary> cheapest  = stationary.stream()
                .min(Comparator.comparingInt(Stationary::getPrice));

        cheapest.ifPresent(p -> System.out.println("cheapest is "+ p));
    }
}


class Stationary {
    String name;
    int price;

    Stationary(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Stationary{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}