package dev.amerida.algoritms.arrays.two_sum;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] numbs, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbs.length; i++) {
            int complement = target - numbs[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(numbs[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}
