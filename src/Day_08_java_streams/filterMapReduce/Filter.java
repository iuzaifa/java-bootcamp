package Day_08_java_streams.filterMapReduce;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Filter {

    public static void main(String[] args) {

        // Stream<T> filter(Predicate<? super T> predicate)


        // Print names that start with the given letter(A to Z, a to z ) (Desire name or letters)
        List<String> names = Arrays.asList(
                "Alice", "Bob", "Anna", "Charlie", "David"
        );
        List<String> filteredNames = names.stream()
                .filter(name -> name.startsWith("Alice")) //linkedin.com/in/iuzaifa
//                .toList();
                .collect(Collectors.toList());
        System.out.println(filteredNames);






        // Check even numbers
        List<Integer> nums = List.of(10, 15, 20, 25, 30);
        nums.stream()
                .filter(n-> n % 2 == 0)
                .forEach(System.out::println);



        // Print marks that are less than 23
        List<Integer> marks = List.of(23, 45,67,89,90,78,56,32,12,34,23,12);
        marks.stream()
                .filter(n -> n < 23)
                .forEach(System.out::println);



        List<Employee> employees = Arrays.asList(
                new Employee(1, "Huzaifa", "huzaifa@gmail.com", "+919876543210"),       // India
                new Employee(2, "Ahmed", "ahmed@gmail.com", "+12025550173"),            // USA
                new Employee(3, "Ali", "ali@gmail.com", "+9187654321"),                 // India
                new Employee(4, "Emily", "emily@gmail.com", "+61412345678"),            // Australia
                new Employee(5, "Hans", "hans@gmail.com", "+4915123456789"),            // Germany
                new Employee(6, "Satoshi", "satoshi@gmail.com", "+819012345678"),       // Japan
                new Employee(7, "Wei", "wei@gmail.com", "+6581234567"),                 // Singapore
                new Employee(8, "Carlos", "carlos@gmail.com", "+5511912345678"),        // Brazil
                new Employee(9, "Luis", "luis@gmail.com", "+5215512345678"),            // Mexico
                new Employee(10, "Fahad", "fahad@gmail.com", "+966501234567")           // Saudi Arabia
        );

        List<Employee> indianEmployee = employees.stream()
                .filter(employee -> employee.getPhone().startsWith("+91"))
                .toList();

        for (Employee e : indianEmployee){
            System.out.println("indianEmployee : " + e);
        }


    }
}

class Employee {

    private int id;
    private String name;
    private String email;
    private String phone;

    public Employee(int id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        int i = 0;
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
