package dev.amerida.algoritms.common.print_missing_numbers;

import java.util.HashSet;
import java.util.Set;

public class MissingNumbers {

    static void main() {
        int[] nums = {1, 2, 4, 5, 9};
        int start = nums[0];
        int end = nums[nums.length - 1];

        Set<Integer> missingNumbers = new HashSet<>();
        for (int num : nums) {
            missingNumbers.add(num);
        }

        for (int i = start; i <= end; i++) {
            if (!missingNumbers.contains(i)) {
                IO.println(i);
            }
        }
    }
}
