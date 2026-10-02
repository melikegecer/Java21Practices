package com.melikegecer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Streams {

    public static void main(String[] args) {
        ex();
    }

    public static void ex1() {
        List<Integer> numbers = List.of(2, 6, 3, 9, 1);

        numbers.stream()
                .filter(n -> n > 5)
                .forEach(System.out::println);
    }

    public static void ex2() {
        List<String> names = List.of("Alice", "Bob", "Charlie", "Amy", "David");

        names.stream()
                .filter(s -> s.startsWith("A"))
                .forEach(System.out::println);
    }

    public static void ex3() {
        List<String> words = List.of("cat", "elephant", "dog");

        words.stream()
                .map(String::length)
                .forEach(System.out::println);
    }

    public static void ex4() {
        List<String> names = List.of("Alice", "Bob", "Charlie", "Amy", "David");

        names.stream()
                .filter(s -> s.length() > 4)
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    public static void ex5() {
        List<Integer> numbers = List.of(5, 1, 4, 2);

        numbers.stream()
                .sorted()
                .forEach(System.out::println);
    }

    public static void ex6() {
        List<Integer> scores = List.of(45, 82, 19, 90, 60, 75);

        scores.stream()
                .filter(n -> n >= 60)
                .sorted()
                .forEach(System.out::println);
    }

    public static void ex7() {
        List<Integer> numbers = List.of(3, 1, 3, 2, 1, 4);

        numbers.stream()
                .distinct()
                .limit(2)
                .forEach(System.out::println);
    }

    public static void ex8() {
        List<Integer> leaderboard = List.of(80, 95, 80, 100, 60, 95, 70);

        leaderboard.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .forEach(System.out::println);
    }

    public static void ex9() {
        List<Integer> numbers = List.of(1, 2, 3, 4);

        int sum = numbers.stream()
                .reduce(0, Integer::sum);

        System.out.println(sum);
    }

    public static void ex10() {
        List<String> words = List.of("Java", "Streams", "Are", "Powerful");

        String result = words.stream()
                .reduce("", (substring, word) -> substring + word + " ").trim();

        System.out.println(result);
    }

    public static void ex11() {
        List<Integer> numbers = List.of(3, 7, 12, 5);

        boolean hasEven = numbers.stream().anyMatch(n -> n % 2 == 0); // stops when it finds 12
        boolean allPositive = numbers.stream().allMatch(n -> n > 0);

        System.out.println(hasEven);
        System.out.println(allPositive);
    }

    public static void ex12() {
        List<Integer> ages = List.of(19, 24, 35, 17, 42);

        boolean allLegalAdults = ages.stream().allMatch(n -> n >= 18);
        boolean anyMinor = ages.stream().anyMatch(n -> n < 18);

        System.out.println(allLegalAdults);
        System.out.println(anyMinor);
    }

    public static void ex13() {
        List<String> words = List.of("cat", "bear", "dog", "wolf");

        Map<Integer, List<String>> byLength = words.stream()
                .collect(Collectors.groupingBy(String::length));

        for (Integer bl : byLength.keySet()) {
            byLength.get(bl).forEach(System.out::println);
        }
    }

    public static void ex14() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8);

        Map<String, List<Integer>> oddEven = numbers.stream()
                .collect(Collectors.groupingBy(n -> n % 2 == 0 ? "Even" : "Odd"));

        oddEven.get("Even").forEach(System.out::println);
        System.out.println("---");
        oddEven.get("Odd").forEach(System.out::println);
    }

    public static void ex15() {
        List<List<String>> nested = List.of(
                List.of("apple", "banana"),
                List.of("cherry", "date")
        );

        nested.stream()
                .flatMap(List::stream)
                .forEach(System.out::println);
    }

    public static void ex16() {
        List<String> sentences = List.of(
                "hello world",
                "java streams are cool",
                "flat map example"
        );

        sentences.stream().flatMap(s -> Arrays.stream(s.split(" "))).distinct().forEach(System.out::println);
    }

    public static void ex17() {
        List<String> items = List.of("apple", "banana", "pear");

        int totalCharacters = items.stream()
                .mapToInt(String::length)
                .sum();

        System.out.println(totalCharacters);
    }

    public static void ex18() {
        List<String> rawPrices = List.of("10", "25", "5", "40", "15");

        double average = rawPrices.stream()
                .mapToInt(Integer::parseInt)
                .average().orElse(0.0);

        System.out.println(average);
    }

    public static void ex19() {
        List<String> names = List.of("Bob", "Charlie", "Alice", "David");

        String match = names.stream()
                .filter(name -> name.startsWith("C"))
                .findFirst()
                .orElse("Not found");

        System.out.println(match);
    }

    public static void ex20() {
        List<Integer> numbers = List.of(3, 7, 12, 19, 24, 5);

        int match = numbers.stream()
                .filter(n -> (n > 10) && (n % 2 == 0))
                .findFirst()
                .orElse(-1);

        System.out.println(match);
    }

    public static void ex21() {
        List<Integer> sortedNumbers = List.of(2, 4, 6, 7, 8, 10);

        sortedNumbers.stream()
                .takeWhile(n -> n % 2 == 0)
                .forEach(System.out::println);

    }

    public static void ex22() {
        List<Integer> responseTimes = List.of(50, 85, 120, 190, 210, 300, 450);

        responseTimes.stream()
                .takeWhile(n -> n < 200)
                .forEach(System.out::println);
    }

    public static void ex23() {
        record Book(String isbn, String title, double price) {
        }

        List<Book> books = List.of(
                new Book("978-1", "Java Basics", 29.99),
                new Book("978-2", "Stream Power", 39.99)
        );

        Map<String, String> isbnToTitle = books.stream()
                .collect(Collectors.toMap(Book::isbn, Book::title));
    }

    public static void ex24() {
        record Product(int id, String name, double price) {
        }

        List<Product> products = List.of(
                new Product(101, "Laptop", 1200.0),
                new Product(102, "Mouse", 25.0),
                new Product(103, "Keyboard", 75.0),
                new Product(104, "Monitor", 300.0)
        );

        Map<Integer, String> results = products.stream()
                .filter(product -> product.price >= 50)
                .collect(Collectors.toMap(Product::id, Product::name));

        System.out.println(results);
    }

    public static void ex25() {
        List<String> words = List.of("cat", "dog", "bear", "wolf", "fox");

        Map<Integer, Long> countByLength = words.stream()
                .collect(Collectors.groupingBy(
                        String::length,
                        Collectors.counting()
                ));

        System.out.println(countByLength);
    }

    public static void ex26() {
        record Employee(String name, String department, int salary) {
        }

        List<Employee> employees = List.of(
                new Employee("Alice", "Engineering", 90000),
                new Employee("Bob", "Engineering", 80000),
                new Employee("Charlie", "HR", 60000),
                new Employee("David", "Marketing", 70000),
                new Employee("Eve", "HR", 65000)
        );

        Map<String, Long> result = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::department,
                        Collectors.counting()
                ));

        System.out.println(result);
    }

    public static void ex27() {
        record Item(String name, String category, int price) {
        }

        List<Item> items = List.of(
                new Item("Laptop", "Electronics", 1200),
                new Item("Mouse", "Electronics", 25),
                new Item("Keyboard", "Electronics", 75),
                new Item("Apple", "Groceries", 2),
                new Item("Milk", "Groceries", 3),
                new Item("Bread", "Groceries", 4),
                new Item("T-shirt", "Clothing", 20)
        );
        Map<String, Integer> totalByCategory = items.stream()
                .collect(Collectors.groupingBy(
                        Item::category,
                        Collectors.summingInt(Item::price)
                ));

        System.out.println(totalByCategory);
    }

    public static void ex28() {
        record Employee(String name, String department, int salary) {
        }

        List<Employee> employees = List.of(
                new Employee("Alice", "Engineering", 90000),
                new Employee("Bob", "Engineering", 80000),
                new Employee("Charlie", "HR", 60000),
                new Employee("David", "Marketing", 70000),
                new Employee("Eve", "HR", 65000)
        );

        Map<String, Integer> result = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::department,
                        Collectors.summingInt(Employee::salary)
                ));

        System.out.println(result);
    }

    public static void ex29() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        Map<Boolean, List<Integer>> evensAndOdds = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));

        System.out.println(evensAndOdds);
    }

    public static void ex30() {
        record Employee(String name, String department, int salary) {
        }

        List<Employee> employees = List.of(
                new Employee("Alice", "Engineering", 90000),
                new Employee("Bob", "Engineering", 80000),
                new Employee("Charlie", "HR", 60000),
                new Employee("David", "Marketing", 70000),
                new Employee("Eve", "HR", 65000)
        );

        Map<Boolean, List<Employee>> result = employees.stream()
                .collect(Collectors.partitioningBy(e -> e.salary >= 75000));

        System.out.println(result);
    }

    public static void ex31() {
        List<Integer> scores = List.of(85, 42, 90, 65, 55);

        Map<Boolean, Long> passFailCounts = scores.stream()
                .collect(Collectors.partitioningBy(
                        score -> score >= 60,
                        Collectors.counting()
                ));
        System.out.println(passFailCounts);
    }

    public static void ex32() {
        record Employee(String name, String department, int salary) {
        }

        List<Employee> employees = List.of(
                new Employee("Alice", "Engineering", 90000),
                new Employee("Bob", "Engineering", 80000),
                new Employee("Charlie", "HR", 60000),
                new Employee("David", "Marketing", 70000),
                new Employee("Eve", "HR", 65000)
        );

        Map<Boolean, Double> result = employees.stream()
                .collect(Collectors.partitioningBy(
                        employee -> employee.salary >= 75000,
                        Collectors.averagingDouble(Employee::salary)
                ));

        System.out.println(result);
    }

    public static void ex33() {
        List<Integer> factors = List.of(2, 3, 4);

        int product = factors.stream()
                .reduce(1, (runningTotal, num) -> runningTotal * num);

        System.out.println(product);
    }

    public static void ex() {
        List<String> words = List.of("Java", "Streams", "Are", "Powerful");

        String result = words.stream()
                .reduce((runningString, str) -> runningString+"-"+str).orElse("");

        System.out.println(result);
    }
    //    public static void ex() {}
    //    public static void ex() {}
    //    public static void ex() {}
    //    public static void ex() {}
    //    public static void ex() {}
    //    public static void ex() {}
    //    public static void ex() {}
    //    public static void ex() {}
}