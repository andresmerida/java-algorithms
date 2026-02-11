package dev.amerida.algoritms.stream.map.to_uppercase_and_join;

import dev.amerida.algoritms.stream.collect.grouping.grouping_eployee.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ToUpperCaseAndJoinWithComa {

    public String toUpperCaseAndJoinWithComa(String[] names) {
        return String.join(",", names).toUpperCase();
    }

    public String toUpperCaseAndJoinWithComa(List<String> names) {
        return String.join(",", names).toUpperCase();
    }

    public String employeesNameToUpperCaseAndJoinWithComa(List<Employee> employees) {
        return employees.stream()
                .map(employee -> employee.name().toUpperCase())
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining(", "));
    }

    public String toUpperCaseAndJoinWithComaWithStream(String[] names) {
        return Arrays.stream(names)
                .map(String::toUpperCase)
                .collect(Collectors.joining(","));
    }
}
