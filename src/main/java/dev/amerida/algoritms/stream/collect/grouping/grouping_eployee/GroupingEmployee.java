package dev.amerida.algoritms.stream.collect.grouping.grouping_eployee;

import java.util.*;
import java.util.stream.Collectors;

public class GroupingEmployee {
    static void main() {
        List<Employee> employees = List.of(
                new Employee(1, "John", 30),
                new Employee(2, "Mary", 35),
                new Employee(3, "Bob", 30),
                new Employee(4, "Mary", 28),
                new Employee(5, "Bob", 30)
        );

        SortedMap<Integer, List<Employee>> map = employees
                .stream()
                .sorted(Comparator.comparing(Employee::name))
                .collect(Collectors.groupingBy(
                        Employee::age,
                        TreeMap::new,
                        Collectors.toList())
                );

        System.out.println(map);

        IntSummaryStatistics statistics = employees.stream()
                .collect(Collectors.summarizingInt(Employee::age));
        IO.println("Min: " + statistics.getMin() + ", Max: " + statistics.getMax());

        IO.println();

        IntSummaryStatistics statistics2 = employees.stream()
                .mapToInt(Employee::age)
                .summaryStatistics();
        IO.println("Min: " + statistics2.getMin() + ", Max: " +
                statistics2.getMax() + ", Average: " + statistics2.getAverage());
    }
}
