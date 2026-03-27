package dev.amerida.algoritms.strings.reverse_each_word_sentence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseEachWordTest {

    private ReverseEachWord reverseEachWord;

    @BeforeEach
    void setUp() {
        reverseEachWord = new ReverseEachWord();
    }

    // reverseWords tests

    @Test
    void reverseWords_singleWord() {
        assertEquals("olleH", reverseEachWord.reverseWords("Hello"));
    }

    @Test
    void reverseWords_multiplWords() {
        assertEquals("olleH dlroW", reverseEachWord.reverseWords("Hello World"));
    }

    @Test
    void reverseWords_sentence() {
        assertEquals("ehT kciuq nworb xof", reverseEachWord.reverseWords("The quick brown fox"));
    }

    @Test
    void reverseWords_singleChar() {
        assertEquals("a", reverseEachWord.reverseWords("a"));
    }

    @Test
    void reverseWords_alreadyReversed() {
        assertEquals("Hello World", reverseEachWord.reverseWords("olleH dlroW"));
    }

    @Test
    void reverseWords_nullThrows() {
        assertThrows(IllegalArgumentException.class, () -> reverseEachWord.reverseWords(null));
    }

    @Test
    void reverseWords_emptyThrows() {
        assertThrows(IllegalArgumentException.class, () -> reverseEachWord.reverseWords(""));
    }

    // reverseWordsWithStringBuilder tests

    @Test
    void reverseWordsWithStringBuilder_singleWord() {
        assertEquals("olleH", reverseEachWord.reverseWordsWithStringBuilder("Hello"));
    }

    @Test
    void reverseWordsWithStringBuilder_multipleWords() {
        assertEquals("olleH dlroW", reverseEachWord.reverseWordsWithStringBuilder("Hello World"));
    }

    @Test
    void reverseWordsWithStringBuilder_sentence() {
        assertEquals("ehT kciuq nworb xof", reverseEachWord.reverseWordsWithStringBuilder("The quick brown fox"));
    }

    @Test
    void reverseWordsWithStringBuilder_singleChar() {
        assertEquals("a", reverseEachWord.reverseWordsWithStringBuilder("a"));
    }

    @Test
    void reverseWordsWithStringBuilder_nullThrows() {
        assertThrows(IllegalArgumentException.class, () -> reverseEachWord.reverseWordsWithStringBuilder(null));
    }

    @Test
    void reverseWordsWithStringBuilder_emptyThrows() {
        assertThrows(IllegalArgumentException.class, () -> reverseEachWord.reverseWordsWithStringBuilder(""));
    }

    // Consistency between both methods

    @Test
    void bothMethods_produceConsistentResults() {
        String input = "Java is awesome";
        assertEquals(
            reverseEachWord.reverseWords(input),
            reverseEachWord.reverseWordsWithStringBuilder(input)
        );
    }
}