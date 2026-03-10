package dev.amerida.algoritms.strings.group_anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            map.computeIfAbsent(Arrays.toString(chars), k -> new ArrayList<>()).add(word);
        }

        return new ArrayList<>(map.values());
    }
}
