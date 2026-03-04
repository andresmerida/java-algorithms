package dev.amerida.algoritms.stream;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FastTest {
    static void main() {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 8, 19, 55, 69, 53, 5, 2, 5);

        list.stream()
                .findFirst()
                .ifPresent(System.out::println);

        IO.println();

        IO.println((long) list.size());
        IO.println();

        list.stream().filter(e -> e % 2 == 0).forEach(System.out::println);
        IO.println();
        list.stream().filter(e -> e % 2 != 0).forEach(System.out::println);
        IO.println();

        list.stream()
                .filter(e -> e.toString().startsWith("5"))
                .forEach(System.out::println);
        IO.println();

        Set<Integer> temp = new HashSet<>();
        Set<Integer> duplicates = list.stream()
                .filter(e -> !temp.add(e))
                .collect(Collectors.toSet());
        IO.println(duplicates);
        IO.println();

        IntSummaryStatistics statistics = list.stream()
                .mapToInt(e -> e)
                .summaryStatistics();
        IO.println(statistics.getMax());
        IO.println(statistics.getMin());
        IO.println();

        int max = list.get(0);
        int min = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
            }
            if (list.get(i) < min) {
                min = list.get(1);
            }
        }
        IO.println(max);
        IO.println(min);
        IO.println();

        list.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
        IO.println();

        int[] numbs = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 13};
        if (numbs.length != Arrays.stream(numbs).distinct().count()) {
            IO.println("Yes, Array contains repeated elements.");
        } else {
            IO.println("No, Array does not contain repeated elements.");
        }
        IO.println();

        Arrays.stream(numbs)
                .map(n -> n * n)
                .filter(n -> n > 50)
                .forEach(System.out::println);
        IO.println();

        Arrays.sort(numbs);
        Arrays.stream(numbs).forEach(System.out::println);
        IO.println();

        List<String> names = List.of("John", "Jane", "Bob", "Alice", "Bob", "Alice");
        names.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
        IO.println();

        Arrays.stream(numbs)
                .max()
                .ifPresent(System.out::println);
        IO.println();

        Stream<Integer> stream = Stream.of(1, 2, 3);
        Stream<Integer> stream2 = Stream.of(4, 5, 6);
        Stream.concat(stream, stream2).forEach(System.out::println);
        IO.println();

        Random random = new Random();
        random.ints(1, 100).limit(5).forEach(System.out::println);
        IO.println();

        Stream.generate(random::nextInt).limit(5).forEach(System.out::println);
        IO.println();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        IO.println(formatter.format(LocalDate.now()));
        IO.println();

        List<String> list2 = null;
        Optional<List<String>> optional = Optional.ofNullable(list2);
        optional.ifPresentOrElse(strings -> strings.forEach(System.out::println), () -> IO.println("Optional is null or empty"));
        IO.println();

        List<Integer> list3 = List.of(10, 1, 10, 2, 100, 100, 100);
        list3.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((key, value) -> System.out.println(key + " : " + value));
        IO.println();

        int[] numbers = {10, 1, 10, 2, 100, 100, 100};
        int number = 100;
        IO.println(Arrays.stream(numbers).filter(n -> n == number).count());
        IO.println();

        List<String> duplicateValues = List.of("John", "Jane", "Bob", "Alice", "Bob", "Alice");
        duplicateValues.stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .forEach((key, value) -> System.out.println(key + " : " + value));
        IO.println();

        List<Employee> employees = List.of(new Employee("John", 3000),
                new Employee("Jane", 4000),
                new Employee("Jane", 4000),
                new Employee("Bob", 5000));
        IO.println(employees.stream()
                .mapToDouble(Employee::salary).sum());
        IO.println();

        String value = "DevByteSchool";
        Map<Character, Long> map = value.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        IO.println(map);
        IO.println();

        String example = "DevByteSchool";
        example.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .findFirst()
                .ifPresent(System.out::println);
    }

    record Employee(String name, double salary) {
    }
}
