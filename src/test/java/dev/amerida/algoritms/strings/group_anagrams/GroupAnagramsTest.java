package dev.amerida.algoritms.strings.group_anagrams;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GroupAnagramsTest {
    private final GroupAnagrams groupAnagrams = new GroupAnagrams();

    @Test
    void groupAnagrams_typicalCase() {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams.groupAnagrams(input);

        assertEquals(3, result.size());
        assertTrue(result.stream().anyMatch(g -> g.size() == 3 && g.containsAll(List.of("eat", "tea", "ate"))));
        assertTrue(result.stream().anyMatch(g -> g.size() == 2 && g.containsAll(List.of("tan", "nat"))));
        assertTrue(result.stream().anyMatch(g -> g.size() == 1 && g.contains("bat")));
    }

    @Test
    void groupAnagrams_singleEmptyString() {
        String[] input = {""};
        List<List<String>> result = groupAnagrams.groupAnagrams(input);

        assertEquals(1, result.size());
        assertEquals(List.of(""), result.getFirst());
    }

    @Test
    void groupAnagrams_allSameAnagram() {
        String[] input = {"abc", "bca", "cab"};
        List<List<String>> result = groupAnagrams.groupAnagrams(input);

        assertEquals(1, result.size());
        assertEquals(3, result.getFirst().size());
        assertTrue(result.getFirst().containsAll(List.of("abc", "bca", "cab")));
    }

    @Test
    void groupAnagrams_noAnagrams() {
        String[] input = {"abc", "def", "ghi"};
        List<List<String>> result = groupAnagrams.groupAnagrams(input);

        assertEquals(3, result.size());
        assertTrue(result.stream().allMatch(g -> g.size() == 1));
    }

    @Test
    void groupAnagrams_singleWord() {
        String[] input = {"hello"};
        List<List<String>> result = groupAnagrams.groupAnagrams(input);

        assertEquals(1, result.size());
        assertEquals(List.of("hello"), result.getFirst());
    }

    @Test
    void groupAnagrams_multipleEmptyStrings() {
        String[] input = {"", "", ""};
        List<List<String>> result = groupAnagrams.groupAnagrams(input);

        assertEquals(1, result.size());
        assertEquals(3, result.getFirst().size());
    }
}