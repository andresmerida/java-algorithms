package dev.amerida.algoritms.stream.map.second_youngest;

import dev.amerida.algoritms.stream.collect.grouping.grouping_eployee.Employee;

import java.util.List;

public class SecondYoungest {

    public int secondYoungest(List<Employee> employees) {
        if (employees == null || employees.isEmpty()) {
            throw new IllegalArgumentException("List cannot be null or empty");
        }

        if (employees.size() == 1) {
            return employees.getFirst().age();
        }

        return employees.stream()
                .mapToInt(Employee::age)
                .sorted()
                .skip(1)
                .findFirst()
                .orElse(0);
    }
}
