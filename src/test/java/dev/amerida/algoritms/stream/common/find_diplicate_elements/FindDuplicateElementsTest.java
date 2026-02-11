package dev.amerida.algoritms.stream.common.find_diplicate_elements;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

class FindDuplicateElementsTest {
    private final FindDuplicateElements findDuplicateElements = new FindDuplicateElements();

    @Test
    void findDuplicateElementsSorted() {
        int[] input = {1, 2, 3, 4, 5, 2, 6, 3};
        SortedSet<Integer> expected = new TreeSet<>(Set.of(2, 3));

        assertEquals(expected, findDuplicateElements.findDuplicateElementsSorted(input));
    }

    @Test
    void findDuplicateElementsSorted_test2() {
        int[] input = {5, 1, 2, 3, 4, 5, 2, 6, 3};
        SortedSet<Integer> expected = new TreeSet<>(Set.of(2, 3, 5));

        assertEquals(expected, findDuplicateElements.findDuplicateElementsSorted(input));
    }

    @Test
    void findDuplicateElementsSorted_null() {
        assertThrows(IllegalArgumentException.class, () -> findDuplicateElements.findDuplicateElementsSorted(null));
    }

    @Test
    void findDuplicateElementsSortedStream() {
        int[] input = {1, 2, 3, 4, 5, 2, 6, 3};
        SortedSet<Integer> expected = new TreeSet<>(Set.of(2, 3));

        assertEquals(expected, findDuplicateElements.findDuplicateElementsSortedStream(input));
    }

    @Test
    void findDuplicateElementsSortedStream_inputUnsorted() {
        int[] input = {5, 1, 2, 3, 4, 5, 2, 6, 3};
        SortedSet<Integer> expected = new TreeSet<>(Set.of(2, 3, 5));

        assertEquals(expected, findDuplicateElements.findDuplicateElementsSortedStream(input));
    }

    @Test
    void findDuplicateElementsSortedStream_null() {
        assertThrows(IllegalArgumentException.class, () -> findDuplicateElements.findDuplicateElementsSortedStream(null));
    }

    @Test
    void findDuplicateElementsSortedDescStream() {
        int[] input = {5, 1, 2, 3, 4, 5, 2, 6, 3};
        Set<Integer> expected = new LinkedHashSet<>();
        expected.add(5);
        expected.add(3);
        expected.add(2);

        assertEquals(expected, findDuplicateElements.findDuplicateElementsSortedDescStream(input));
    }

    @Test
    void findDuplicateElementsSortedDescStream_null() {
        assertThrows(IllegalArgumentException.class, () -> findDuplicateElements.findDuplicateElementsSortedDescStream(null));
    }
}