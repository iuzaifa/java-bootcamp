package Day_08_java_streams.filterMapReduce;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Map {

    public static void main(String[] args) {

        /*

        // The map() function is used to transform each element of the stream.

            <R> Stream<R> map(Function<? super T, ? extends R> mapper)

         */


        List<String> words = Arrays.asList("hello", "world", "java", "streams");
        List<String> uppercaseWords = words.stream()
                .map(String::toUpperCase)
                .toList();
//        System.out.println("Uppercase Words : " + uppercaseWords);


        words.stream()
                .map(String::length)
                .toList();
//                .forEach(System.out::println);



        int [] nums = {4,5,6,7,8,9,9,8,7,6};
        final IntStream intStream = Arrays.stream(nums);
        intStream.map(m -> m * 3).forEach(System.out::println );


        // Step 1: Create a list of User objects
        List<User> userList = List.of(
                new User(2, "Huzaifa", "India"),
                new User(3, "Ubaid", "Saudi")
        );

        // Step 2: Print each User object
        userList.forEach(System.out::println);

        // Step 3: Convert List<User> to List<Employee> using map()
        // For each User, create a new Employee object with same id, name, and country
        List<Employee> employeesList = userList.stream()
                .map(info -> new Employee(info.getId(), info.getName(), info.getCountry()))
                .toList();

        // Step 4: Print each Employee object
        employeesList.forEach(System.out::println);


    }
}

class Employee {
    private int id;
    private String name;
    private String country;

    public Employee(int id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}

class User {
    private int id;
    private String name;
    private String country;

    public User(int id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
