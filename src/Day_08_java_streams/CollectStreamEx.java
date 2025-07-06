package Day_08_java_streams;

import java.sql.Array;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectStreamEx {

    /*
        In Java, the collect() method is a terminal operation in the Stream API used to transform
        the elements of a stream into a different form, like a List, Set, Map, or even a single String.

        stream.collect(Collector.toList());
        stream.collect(Collector.toSet());
        stream.collect(Collector.toMap());


     */
    public static void main(String[] args) {

        // 1. Collect into List
        List<String> names = Stream.of("Abu", "Huzaifa", "Ali")
                .collect(Collectors.toList());
        System.out.println(names);

        // 2. Collect into Set
        Set<Integer> numbers = Stream.of(1, 2, 2, 3)
                .collect(Collectors.toSet());
        System.out.println(numbers);

        // 3. Collect into Map
        Map<Integer, String> map = Stream.of("Java", "Spring - boot", "React js", "PostgreeSql")
                .collect(Collectors.toMap(i -> i.length() , i -> i));
        System.out.println("map -> " + map);


        // whenever get duplicate id do this
        Map<Integer, String> duplicatesmap = Stream.of("Java", "Spring-boot", "React js", "PostgreeSql")
                .collect(Collectors
                        .toMap(i -> i.length() , i -> i,
                                (a , b) -> a + ", " +b) // merging duplicates
                );
        System.out.println("duplicatesmap -> " + duplicatesmap);


        // 4. Join Strings

        String result = Stream.of("Java", "is", "cool")
                .collect(Collectors.joining(" "));
        System.out.println("After join -> "+ result);


        // 5. Grouping by
        Map<String, List<String>> grouped = Stream.of("apple", "banana", "orange")
                .collect(Collectors.groupingBy(words -> words.substring(0, 2)));
        System.out.println(grouped);

        List<Employee> employees = Arrays.asList(
                new Employee("Mohammad", 1000000L, "AI Agent Developer"),
                new Employee("Priya Sharma", 750000L, "Data Scientist"),
                new Employee("Arjun Singh", 1200000L, "Lead Software Engineer"),
                new Employee("Sneha Patel", 600000L, "Marketing Specialist"),
                new Employee("Rahul Kumar", 850000L, "DevOps Engineer"),
                new Employee("Anjali Devi", 900000L, "Product Manager"),
                new Employee("Vikram Reddy", 700000L, "UI/UX Designer"),
                new Employee("Kavita Das", 550000L, "Technical Writer"),
                new Employee("Suresh Menon", 1100000L, "Solutions Architect"),
                new Employee("Deepa Gupta", 680000L, "Quality Assurance Analyst")
        );

        String  n = "Product Manager";
        Map<Boolean, List<Employee>> booleanListMap =
                employees.stream()
                        // by salary
//                        .collect(Collectors.partitioningBy(e -> e.getSalary() >= 1000000L));
                        // by getDepartment
        .collect(Collectors.partitioningBy(e-> e.getDepartment().equals(n)));
        System.out.println("-------------- expected case----------------------" );
        booleanListMap.get(true).forEach(System.out::println);

        System.out.println("-------------- Default case---------------------" );
        booleanListMap.get(false).forEach(System.out::println);




    }
}

class Employee {
    String name;
    Long salary;
    String department;

    public Employee(String name, Long salary, String department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }
}