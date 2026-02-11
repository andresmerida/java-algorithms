package dev.amerida.algoritms.stream.common.find_diplicate_elements;

import java.util.*;
import java.util.stream.Collectors;

public class FindDuplicateElements {

    public SortedSet<Integer> findDuplicateElementsSorted(int[] numbs) {
        if (numbs == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        Set<Integer> set = new HashSet<>();
        SortedSet<Integer> sortedSet = new TreeSet<>();
        for (int num : numbs) {
            if (!set.add(num)) {
                sortedSet.add(num);
            }
        }
        return sortedSet;
    }

    public SortedSet<Integer> findDuplicateElementsSortedStream(int[] numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        Set<Integer> seen = new HashSet<>();
        return Arrays.stream(numbers)
                .boxed()
                .filter(number -> !seen.add(number))
                .collect(Collectors.toCollection(TreeSet::new));
    }

    public LinkedHashSet<Integer> findDuplicateElementsSortedDescStream(int[] numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        Set<Integer> seen = new HashSet<>();
        return Arrays.stream(numbers)
                .boxed()
                .filter(number -> !seen.add(number))
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
