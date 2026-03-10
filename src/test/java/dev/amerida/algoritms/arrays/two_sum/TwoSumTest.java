package dev.amerida.algoritms.arrays.two_sum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoSumTest {
    private final TwoSum twoSum = new TwoSum();

    @Test
    void twoSum() {
        int[] numbs = {2, 7, 11, 15};
        int target = 9;
        int[] expected = {0, 1};
        assertArrayEquals(expected, twoSum.twoSum(numbs, target));
    }

    @Test
    void twoSum_throwException() {
        int[] numbs = {2, 7, 11, 15};
        int target = 10;

        assertThrows(IllegalArgumentException.class, () -> twoSum.twoSum(numbs, target));
    }
}