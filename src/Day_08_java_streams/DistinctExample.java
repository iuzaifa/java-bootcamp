package Day_08_java_streams;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DistinctExample {


    public static void main(String[] args) {


        /*
            The distinct() method removes duplicate elements from the stream —
            it ensures only unique values are kept.

            // Distinct gives unique elements String, Integers...


         */

        List<Integer> num = List.of(1, 2, 2, 3, 4, 4, 5);
        num.stream().distinct().forEach(System.out::println);


        List<String> names = List.of("abu", "ali", "abu", "huzaifa");
        names.stream()
                .distinct()
                .forEach(System.out::println);


        List<User> users = List.of(
                new User(1, "Abu"),
                new User(2, "Ali"),
                new User(1, "Abu") // duplicate
        );



        List<User> unique = users.stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println(unique);

    }
}

class User {
    int id;
    String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return id == user.id && name.equals(user.name);
    }
}