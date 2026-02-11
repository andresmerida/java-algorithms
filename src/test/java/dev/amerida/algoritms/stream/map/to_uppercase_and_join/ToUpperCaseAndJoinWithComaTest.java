package dev.amerida.algoritms.stream.map.to_uppercase_and_join;

import dev.amerida.algoritms.stream.collect.grouping.grouping_eployee.Employee;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ToUpperCaseAndJoinWithComaTest {
    private final ToUpperCaseAndJoinWithComa toUpperCaseAndJoinWithComa = new ToUpperCaseAndJoinWithComa();

    @Test
    void toUpperCaseAndJoinWithComa_Array() {
        String[] names = {"John", "Mary", "Bob"};
        assertEquals("JOHN,MARY,BOB", toUpperCaseAndJoinWithComa.toUpperCaseAndJoinWithComa(names));
    }

    @Test
    void toUpperCaseAndJoinWithComa_List() {
        List<String> names = List.of("John", "Mary", "Bob");
        assertEquals("JOHN,MARY,BOB", toUpperCaseAndJoinWithComa.toUpperCaseAndJoinWithComa(names));
    }

    @Test
    void toUpperCaseAndJoinWithComaWithStream() {
        String[] names = {"John", "Mary", "Bob"};
        assertEquals("JOHN,MARY,BOB", toUpperCaseAndJoinWithComa.toUpperCaseAndJoinWithComaWithStream(names));
    }

    @Test
    void employeesNameToUpperCaseAndJoinWithComa() {
        List<Employee> employees = List.of(new Employee(1, "John", 30), new Employee(2, "Mary", 35));
        assertEquals("MARY, JOHN", toUpperCaseAndJoinWithComa.employeesNameToUpperCaseAndJoinWithComa(employees));
    }
}