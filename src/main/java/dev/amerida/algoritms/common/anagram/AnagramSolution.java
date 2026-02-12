package dev.amerida.algoritms.common.anagram;

import java.util.HashMap;
import java.util.Map;

public class AnagramSolution {

    public boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) return false;

        str1 = normalize(str1);
        str2 = normalize(str2);

        int[] counts = new int[26]; // ascii from a to z
        for (int i = 0; i < str1.length(); i++) {
            counts[str1.charAt(i) - 'a']++;
            counts[str2.charAt(i) - 'a']--;
        }

        for (int count : counts) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    public boolean isAnagramWithMap(String str1, String str2) {
        if (str1.length() != str2.length()) return false;

        str1 = normalize(str1);
        str2 = normalize(str2);

        Map<Character, Integer> sortedMapStr1 = new HashMap<>();
        for (char c : str1.toCharArray()) {
            sortedMapStr1.put(c, sortedMapStr1.getOrDefault(c, 0) + 1);
        }

        for (char c : str2.toCharArray()) {
            if (!sortedMapStr1.containsKey(c)) {
                return false;
            }
            sortedMapStr1.put(c, sortedMapStr1.get(c) - 1);
            if (sortedMapStr1.get(c) == 0) {
                sortedMapStr1.remove(c);
            }
        }

        return sortedMapStr1.isEmpty();
    }

    private String normalize(String str) {
        return str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }
}
