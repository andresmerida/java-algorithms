package dev.amerida.algoritms.stream.collect.sumarizing;

import dev.amerida.algoritms.stream.collect.grouping.grouping_eployee.Employee;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;

public class SummarizingInt {

    public Map<String, ? extends Number> getSummaryStatistics(List<Employee> employees) {
        if (employees == null || employees.isEmpty()) {
            throw new IllegalArgumentException("List cannot be null or empty");
        }

        if (employees.size() == 1) {
            return Map.of(
                    "Min", employees.getFirst().age(),
                    "Max", employees.getFirst().age(),
                    "Average", (double) employees.getFirst().age(),
                    "Sum", (long) employees.getFirst().age());
        }

        IntSummaryStatistics statistics = employees.stream()
                .mapToInt(Employee::age)
                .summaryStatistics();

        return Map.of(
                "Min", statistics.getMin(),
                "Max", statistics.getMax(),
                "Average", statistics.getAverage(),
                "Sum", statistics.getSum());
    }
}
