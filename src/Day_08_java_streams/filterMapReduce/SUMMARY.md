

# Java Streams: A Powerful Abstraction for Data Processing

Java Streams, introduced in Java 8, provide a high-level, declarative, and functional way to process sequences of elements. They are not data structures themselves but rather a pipeline of operations that process data from a source (like a collection, array, or I/O channel). Streams emphasize what to do rather than how to do it, making code more concise, readable, and often more performant (especially with parallel processing).

## Key Characteristics of Java Streams

* **Functional**: Operations are expressed as lambda expressions or method references.
* **Lazy**: Operations are only performed when a terminal operation is invoked.
* **Non-interfering**: Stream operations do not modify the underlying data source.
* **Stateless**: Operations do not maintain any state across elements.
* **Consumable**: A stream can be traversed only once. If you need to re-process the data, you need to create a new stream from the source.

## Stream Life Cycle

A typical stream pipeline consists of:

* **Source**: Where the data comes from (e.g., List, Set, Array, Files.lines()).
* **Zero or More Intermediate Operations**: These operations transform the stream into another stream. They are lazy and don't produce a result until a terminal operation is called. Examples: `filter()`, `map()`, `sorted()`, `distinct()`, `limit()`, `skip()`.
* **One Terminal Operation**: These operations produce a result or a side effect. They are eager and trigger the execution of all intermediate operations. Examples: `forEach()`, `collect()`, `reduce()`, `count()`, `min()`, `max()`, `findFirst()`, `anyMatch()`, `allMatch()`.

## Core Stream Operations

### 1. `filter()`

The `filter()` intermediate operation is used to select elements from a stream that match a given predicate. It produces a new stream containing only the elements for which the predicate returns true.

```java
Stream<T> filter(Predicate<? super T> predicate)
```

**Example:**

```java
List<String> names = Arrays.asList("Alice", "Bob", "Anna", "Charlie", "David");

List<String> filteredNames = names.stream()
                                  .filter(name -> name.startsWith("A"))
                                  .toList();

System.out.println("Names starting with 'A': " + filteredNames);
```

### 2. `map()`

The `map()` intermediate operation transforms each element of a stream into another object by applying a given function.

```java
<R> Stream<R> map(Function<? super T, ? extends R> mapper)
```

**Example:**

```java
List<String> words = Arrays.asList("hello", "world", "java", "streams");

List<String> uppercaseWords = words.stream()
                                   .map(String::toUpperCase)
                                   .toList();

List<Integer> wordLengths = words.stream()
                                 .map(String::length)
                                 .toList();
```

### 3. `flatMap()`

The `flatMap()` operation flattens a stream of collections into a single stream.

```java
<R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper)
```

**Example:**

```java
List<List<String>> listOfLists = Arrays.asList(
    Arrays.asList("a", "b"),
    Arrays.asList("c", "d")
);

List<String> flatList = listOfLists.stream()
                                   .flatMap(List::stream)
                                   .toList();
```

### 4. `findFirst()`

The `findFirst()` terminal operation returns the first element in the stream wrapped in an Optional.

```java
Optional<T> findFirst()
```

**Example:**

```java
List<String> names = Arrays.asList("Ali", "Zaid", "Omar");
Optional<String> first = names.stream().findFirst();
first.ifPresent(System.out::println);
```

### 5. `reduce()`

The `reduce()` method takes a stream of values and combines them into one single result.
It does this by repeatedly applying a combining rule (like adding or multiplying).


Common Overloads:

```java
Optional<T> reduce(BinaryOperator<T> accumulator)
T reduce(T identity, BinaryOperator<T> accumulator)
<U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner)
```

**Example:**

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
int sum = numbers.stream().reduce(0, Integer::sum);
Optional<Integer> product = numbers.stream().reduce((a, b) -> a * b);

List<String> words = Arrays.asList("Hello", " ", "World", "!");
String combinedString = words.stream().reduce("", String::concat);
```

### 6. Parallel Streams

Parallel streams enable data processing concurrently. They leverage the Fork/Join framework internally.

```java
List<String> data = Arrays.asList("a", "b", "c");
data.parallelStream().forEach(System.out::println);

Stream<Integer> parallelStream = numbers.stream().parallel();
```

**Example:**

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

int sumSequential = numbers.stream().mapToInt(Integer::intValue).sum();
int sumParallel = numbers.parallelStream().mapToInt(Integer::intValue).sum();
```

### 7. Stream Basics (Stream Creation)

Creating Streams:

```java
List<String> list = Arrays.asList("a", "b", "c");
Stream<String> streamFromList = list.stream();

String[] array = {"d", "e", "f"};
Stream<String> streamFromArray = Arrays.stream(array);

Stream<String> streamOfElements = Stream.of("g", "h", "i");

Stream.Builder<String> builder = Stream.builder();
builder.add("j").add("k").add("l");
Stream<String> builtStream = builder.build();

Stream<Integer> infiniteNumbers = Stream.iterate(0, n -> n + 2).limit(5);

Stream<Double> randomNumbers = Stream.generate(Math::random).limit(3);
```

From I/O:

```java
try (Stream<String> lines = Files.lines(Paths.get("myfile.txt"))) {
    lines.forEach(System.out::println);
} catch (IOException e) {
    e.printStackTrace();
}
```

Other Basic Operations:

```java
Stream.of("apple", "banana").forEach(System.out::println);
long count = Stream.of(1, 2, 3).count();
Stream.of(1, 2, 2, 3, 1).distinct().forEach(System.out::println);
Stream.of("C", "A", "B").sorted().forEach(System.out::println);
```

### 8. Stream Collectors

Collectors are used for mutable reduction, such as collecting elements into collections, joining strings, or computing statistics.

```java
<R, A> R collect(Collector<? super T, A, R> collector)
```

Common Collectors:

```java
List<String> list = names.stream().collect(Collectors.toList());
Set<Integer> set = numbers.stream().collect(Collectors.toSet());

Map<Integer, String> fruitMap = fruits.stream().collect(Collectors.toMap(String::length, s -> s));
Map<Integer, String> fruitMapUnique = fruits.stream().collect(Collectors.toMap(String::length, s -> s, (a, b) -> a + "," + b));

String joinedString = words.stream().collect(Collectors.joining(", "));

Map<String, List<Person>> peopleByCity = people.stream().collect(Collectors.groupingBy(Person::getCity));
Map<Boolean, List<Integer>> evenOdd = numbers.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
long count = numbers.stream().collect(Collectors.counting());

IntSummaryStatistics stats = numbers.stream().collect(Collectors.summarizingInt(Integer::intValue));
```

### 9. Stream Sorting (`sorted()`)

The `sorted()` intermediate operation sorts elements either by natural order or using a custom comparator.

```java
Stream<T> sorted()
Stream<T> sorted(Comparator<? super T> comparator)
```

**Example:**

```java
List<String> fruits = Arrays.asList("Orange", "Apple", "Banana", "Grape");

List<String> sortedFruitsNatural = fruits.stream().sorted().toList();
List<String> sortedFruitsByLength = fruits.stream().sorted(Comparator.comparing(String::length)).toList();
List<String> sortedFruitsReverse = fruits.stream().sorted(Comparator.reverseOrder()).toList();
```

---

## Beginner Exercises

1. Print all even numbers from a list.
2. Convert a list of strings to uppercase.
3. Find the first word that starts with "J" from a list.
4. Count the number of unique elements in a list.
5. Flatten a list of lists into a single list using `flatMap()`.
6. Group names by their first letter.
7. Count the number of elements greater than 50.

## Common Interview Questions

1. What is the difference between `map()` and `flatMap()`?
2. How does `filter()` work in streams?
3. What are terminal and intermediate operations in Java Streams?
4. What does `reduce()` do? How is it different from `collect()`?
5. What precautions should be taken while using `parallelStream()`?
6. How can you sort a stream by custom logic?
7. What are collectors in Java? Give examples.






```
| Method             | Purpose                      | Return Type        |
| ------------------ | ---------------------------- | ------------------ |
| `filter()`         | Filter elements              | Stream<T>          |
| `map()`            | Transform elements           | Stream<R>          |
| `reduce()`         | Combine elements into one    | Optional<T> or T   |
| `collect()`        | Collect into list, set, etc. | List, Set, etc.    |
| `sorted()`         | Sort elements                | Stream<T>          |
| `distinct()`       | Remove duplicates            | Stream<T>          |
| `limit(n)`         | Take first `n` elements      | Stream<T>          |
| `skip(n)`          | Skip first `n` elements      | Stream<T>          |
| `parallelStream()` | Multi-threaded stream        | Parallel Stream<T> |
```