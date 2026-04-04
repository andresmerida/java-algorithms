package dev.amerida.algoritms.stream;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class StreamMain {
    static void main() {
        Predicate<Integer> predicate = i -> i % 2 == 0;
        Function<Integer, Integer> function = i -> i * 2;
        Consumer<Integer> consumer = IO::println;
        Supplier<Integer> supplier = () -> 5;

        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        list.forEach(IO::print);
        IO.println();

        list.stream()
                .filter(num -> num % 2 == 0)
                .forEach(IO::print);
        IO.println();

        list.stream()
                .filter(num -> num % 2 == 0)
                .map(num -> num * 2)
                .forEach(IO::print);
        IO.println();

        long counter = list.stream()
                .filter(num -> num % 2 == 0)
                .count();
        IO.println("Counter: " + counter);

        list.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(IO::print);
        IO.println();

        // print all employees that belong to the same department 'Tech'
        List<Employee> employees = List.of(
                new Employee(1, "John", "Tech"),
                new Employee(2, "Jane", "Tech"),
                new Employee(3, "Bob", "Sales"),
                new Employee(4, "Alice", "Sales"),
                new Employee(5, "David", "Tech"),
                new Employee(6, "Eve", "Tech"),
                new Employee(7, "Frank", "Sales"),
                new Employee(8, "Grace", "Sales"),
                new Employee(9, "Henry", "Tech"),
                new Employee(10, "John", "Tech")
        );
        employees.stream()
                .filter(e -> e.department().equals("Tech"))
                .forEach(e -> IO.print(e.name()));
        IO.println();

        Set<String> set = employees.stream()
                .filter(employee -> employee.department.equals("Tech"))
                .map(employee -> employee.name)
                .collect(Collectors.toSet());
        IO.println(set);

        Map<Integer, String> mapEmployees = employees.stream()
                .collect(Collectors.toMap(Employee::id, Employee::name));
        IO.println(mapEmployees);

        Optional<Employee> employeeOptional = employees.stream()
                .findFirst();
        employeeOptional.ifPresent(IO::println);

        Optional<Employee> employeeOptional2 = employees.stream()
                .filter(employee -> employee.name().startsWith("J"))
                .findAny();
        employeeOptional2.ifPresent((employee -> {
            IO.println("FindAny: " + employee.name());
        }));

        boolean anyMatch = employees.stream()
                .anyMatch(employee -> employee.name().startsWith("J"));
        IO.println("AnyMatch: " + anyMatch);

        boolean allMatch = employees.stream()
                .anyMatch(employee -> employee.name().startsWith("J"));
        IO.println("AllMatch: " + allMatch);

        boolean noneMatch = employees.stream()
                .noneMatch(employee -> employee.name().startsWith("X"));
        IO.println("NoneMatch: " + noneMatch);

        Optional<Employee> employeeOptionalParallel = employees.parallelStream()
                .filter(employee -> employee.name().startsWith("J"))
                .findAny();
        employeeOptionalParallel.ifPresent((employee -> {
            IO.println("Parallel FindAny: " + employee.name());
        }));
    }

    record Employee(int id, String name, String department) {
    }
}
