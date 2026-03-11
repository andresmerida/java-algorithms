package dev.amerida.algoritms.strings.most_frequent_word;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MostFrequentWordTest {

    private final MostFrequentWord mostFrequentWord = new MostFrequentWord();

    // --- getMostFrequentWord ---

    @Test
    void getMostFrequentWord_singleMostFrequent() {
        String input = "apple banana apple orange banana apple";
        assertEquals("apple", mostFrequentWord.getMostFrequentWord(input));
    }

    @Test
    void getMostFrequentWord_singleWord() {
        String input = "hello";
        assertEquals("hello", mostFrequentWord.getMostFrequentWord(input));
    }

    @Test
    void getMostFrequentWord_allUnique() {
        String input = "one two three four";
        String result = mostFrequentWord.getMostFrequentWord(input);
        assertTrue(input.contains(result));
    }

    @Test
    void getMostFrequentWord_multipleSpaces() {
        String input = "cat  cat   dog";
        assertEquals("cat", mostFrequentWord.getMostFrequentWord(input));
    }

    // --- getMostFrequentWordWithStream ---

    @Test
    void getMostFrequentWordWithStream_singleMostFrequent() {
        String input = "java java python go";
        assertEquals("java", mostFrequentWord.getMostFrequentWordWithStream(input));
    }

    @Test
    void getMostFrequentWordWithStream_singleWord() {
        String input = "hello";
        assertEquals("hello", mostFrequentWord.getMostFrequentWordWithStream(input));
    }

    @Test
    void getMostFrequentWordWithStream_allUnique() {
        String input = "a b c d";
        String result = mostFrequentWord.getMostFrequentWordWithStream(input);
        assertTrue(input.contains(result));
    }

    @Test
    void getMostFrequentWordWithStream_nullInput() {
        assertThrows(IllegalArgumentException.class,
                () -> mostFrequentWord.getMostFrequentWordWithStream(null));
    }

    @Test
    void getMostFrequentWordWithStream_emptyInput() {
        assertThrows(IllegalArgumentException.class,
                () -> mostFrequentWord.getMostFrequentWordWithStream(""));
    }

    @Test
    void getMostFrequentWordWithStream_multipleSpaces() {
        String input = "dog  dog   cat";
        assertEquals("dog", mostFrequentWord.getMostFrequentWordWithStream(input));
    }
}