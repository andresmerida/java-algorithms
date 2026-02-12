package dev.amerida.algoritms.common.anagram;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnagramSolutionTest {
    private final AnagramSolution anagramSolution = new AnagramSolution();

    @Test
    void isAnagram() {
        String str1 = "Listen";
        String str2 = "Silent";

        assertTrue(anagramSolution.isAnagram(str1, str2));
    }

    @Test
    void isAnagram_True() {
        String str1 = "The Morse Code";
        String str2 = "Here come dots";

        assertTrue(anagramSolution.isAnagram(str1, str2));
    }

    @Test
    void isAnagram_False() {
        String str1 = "Listen";
        String str2 = "Listen1";

        assertFalse(anagramSolution.isAnagram(str1, str2));
    }

    @Test
    void isAnagramWithMap() {
        String str1 = "Listen";
        String str2 = "Silent";

        assertTrue(anagramSolution.isAnagramWithMap(str1, str2));
    }

    @Test
    void isAnagramWithMap_True() {
        String str1 = "The Morse Code";
        String str2 = "Here come dots";

        assertTrue(anagramSolution.isAnagramWithMap(str1, str2));
    }

    @Test
    void isAnagramWithMap_False() {
        String str1 = "Listen";
        String str2 = "Listen1";

        assertFalse(anagramSolution.isAnagramWithMap(str1, str2));
    }
}