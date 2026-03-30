package dev.amerida.algoritms.leed_code.binary_search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    private final BinarySearch binarySearch = new BinarySearch();

    @Test
    void targetFound_returnsIndex() {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        assertEquals(4, binarySearch.search(nums, 9));
    }

    @Test
    void targetNotFound_returnsMinusOne() {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        assertEquals(-1, binarySearch.search(nums, 2));
    }

    @Test
    void targetAtFirstIndex_returnsZero() {
        int[] nums = {1, 3, 5, 7};
        assertEquals(0, binarySearch.search(nums, 1));
    }

    @Test
    void targetAtLastIndex_returnsLastIndex() {
        int[] nums = {1, 3, 5, 7};
        assertEquals(3, binarySearch.search(nums, 7));
    }

    @Test
    void singleElementArray_targetFound() {
        int[] nums = {5};
        assertEquals(0, binarySearch.search(nums, 5));
    }

    @Test
    void singleElementArray_targetNotFound() {
        int[] nums = {5};
        assertEquals(-1, binarySearch.search(nums, 3));
    }

    @Test
    void negativeNumbers_targetFound() {
        int[] nums = {-10, -5, -3, -1};
        assertEquals(1, binarySearch.search(nums, -5));
    }
}