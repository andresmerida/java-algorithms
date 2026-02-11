package dev.amerida.algoritms.stream.map.second_youngest;

import dev.amerida.algoritms.stream.collect.grouping.grouping_eployee.Employee;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SecondYoungestTest {
    private final SecondYoungest secondYoungest = new SecondYoungest();

    @Test
    void secondYoungest() {
        List<Employee> employees = List.of(
                new Employee(1, "John", 30),
                new Employee(2, "Mary", 35),
                new Employee(3, "Bob", 30),
                new Employee(4, "Mary", 28),
                new Employee(5, "Bob", 30)
        );

        assertEquals(30, secondYoungest.secondYoungest(employees));
    }

    @Test
    void secondYoungest_size_1() {
        List<Employee> employees = List.of(
                new Employee(2, "Mary", 35)
        );

        assertEquals(35, secondYoungest.secondYoungest(employees));
    }
}