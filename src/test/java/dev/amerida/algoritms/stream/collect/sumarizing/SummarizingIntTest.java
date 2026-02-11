package dev.amerida.algoritms.stream.collect.sumarizing;

import dev.amerida.algoritms.stream.collect.grouping.grouping_eployee.Employee;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SummarizingIntTest {
    private final SummarizingInt summarizingInt = new SummarizingInt();

    @Test
    void getSummaryStatistics() {
        List<Employee> employees = List.of(
                new Employee(1, "John", 30),
                new Employee(2, "Mary", 35),
                new Employee(3, "Bob", 30),
                new Employee(4, "Mary", 28),
                new Employee(5, "Bob", 30)
        );

        Map<String, ? extends Number> expected = Map.of(
                "Min", 28,
                "Max", 35,
                "Average", 30.6d,
                "Sum", 153L);

        assertEquals(expected, summarizingInt.getSummaryStatistics(employees));
    }

    @Test
    void getSummaryStatistics_size_1() {
        List<Employee> employees = List.of(new Employee(1, "John", 30));
        assertEquals(Map.of("Min", 30, "Max", 30, "Average", 30d, "Sum", 30L),
                summarizingInt.getSummaryStatistics(employees));
    }

    @Test
    void getSummaryStatistics_empty() {
        assertThrows(IllegalArgumentException.class, () -> summarizingInt.getSummaryStatistics(List.of()));
    }

    @Test
    void getSummaryStatistics_null() {
        assertThrows(IllegalArgumentException.class, () -> summarizingInt.getSummaryStatistics(null));
    }
}