package dev.amerida.algoritms.common.gast_station;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GasStationProblemTest {
    private final GasStationProblem gasStationProblem = new GasStationProblem();

    @Test
    void machine() {
        List<Integer> input = List.of(4, 6, 6, 5, 7, 3, 2, 5);
        int expected = 1;
        assertEquals(expected, gasStationProblem.machine(input));
    }

    @Test
    void machine_2() {
        List<Integer> input = List.of(2, 4, 3, 4, 4, 3);
        int expected = -1;
        assertEquals(expected, gasStationProblem.machine(input));
    }

    @Test
    void machine_3() {
        List<Integer> input = List.of(2, 3, 2, 3, 5, 3);
        int expected = 2;
        assertEquals(expected, gasStationProblem.machine(input));
    }
}