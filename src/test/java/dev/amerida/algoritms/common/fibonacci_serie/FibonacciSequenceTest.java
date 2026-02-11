package dev.amerida.algoritms.common.fibonacci_serie;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciSequenceTest {
    private final FibonacciSequence fibonacciSequence = new FibonacciSequence();

    @Test
    void fibonacciIterative() {
        int input = 10;
        int[] expected = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34};
        assertArrayEquals(expected, fibonacciSequence.fibonacciIterative(input));
    }

    @Test
    void fibonacciIterative_1() {
        int input = 1;
        int[] expected = {0};
        assertArrayEquals(expected, fibonacciSequence.fibonacciIterative(input));
    }

    @Test
    void fibonacciIterative_2() {
        int input = 2;
        int[] expected = {0, 1};
        assertArrayEquals(expected, fibonacciSequence.fibonacciIterative(input));
    }

    @Test
    void fibonacciRecursive() {
        int input = 10;
        int[] expected = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34};
        assertArrayEquals(expected, fibonacciSequence.fibonacciRecursive(input));
    }

    @Test
    void fibonacciRecursive_1() {
        int input = 1;
        int[] expected = {0};
        assertArrayEquals(expected, fibonacciSequence.fibonacciRecursive(input));
    }

    @Test
    void fibonacciRecursive_2() {
        int input = 2;
        int[] expected = {0, 1};
        assertArrayEquals(expected, fibonacciSequence.fibonacciRecursive(input));
    }

    @Test
    void getLastFibonacciSequence() {
        int input = 10;
        int expected = 34;
        assertEquals(expected, fibonacciSequence.getLastFibonacciSequence(input));
    }
}