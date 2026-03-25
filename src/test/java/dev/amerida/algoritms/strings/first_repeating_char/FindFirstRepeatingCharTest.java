package dev.amerida.algoritms.strings.first_repeating_char;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindFirstRepeatingCharTest {

    private FindFirstRepeatingChar finder;

    @BeforeEach
    void setUp() {
        finder = new FindFirstRepeatingChar();
    }

    @Test
    void findFirstRepeatingChar_returnsFirstRepeatingChar() {
        assertEquals('l', finder.findFirstRepeatingChar("hello"));
    }

    @Test
    void findFirstRepeatingChar_multipleRepeating_returnsFirst() {
        assertEquals('a', finder.findFirstRepeatingChar("abacabad"));
    }

    @Test
    void findFirstRepeatingChar_noRepeating_returnsNullChar() {
        assertEquals('\0', finder.findFirstRepeatingChar("abcde"));
    }

    @Test
    void findFirstRepeatingChar_singleChar_returnsNullChar() {
        assertEquals('\0', finder.findFirstRepeatingChar("a"));
    }

    @Test
    void findFirstRepeatingChar_allSameChars_returnsChar() {
        assertEquals('a', finder.findFirstRepeatingChar("aaaa"));
    }

    @Test
    void findFirstRepeatingChar_nullInput_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> finder.findFirstRepeatingChar(null));
    }

    @Test
    void findFirstRepeatingChar_emptyInput_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> finder.findFirstRepeatingChar(""));
    }

    @Test
    void findFirstRepeatingCharWithStream_returnsFirstRepeatingChar() {
        assertEquals('l', finder.findFirstRepeatingCharWithStream("hello"));
    }

    @Test
    void findFirstRepeatingCharWithStream_multipleRepeating_returnsFirst() {
        assertEquals('a', finder.findFirstRepeatingCharWithStream("abacabad"));
    }

    @Test
    void findFirstRepeatingCharWithStream_noRepeating_returnsNullChar() {
        assertEquals('\0', finder.findFirstRepeatingCharWithStream("abcde"));
    }

    @Test
    void findFirstRepeatingCharWithStream_singleChar_returnsNullChar() {
        assertEquals('\0', finder.findFirstRepeatingCharWithStream("a"));
    }

    @Test
    void findFirstRepeatingCharWithStream_allSameChars_returnsChar() {
        assertEquals('a', finder.findFirstRepeatingCharWithStream("aaaa"));
    }

    @Test
    void findFirstRepeatingCharWithStream_nullInput_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> finder.findFirstRepeatingCharWithStream(null));
    }

    @Test
    void findFirstRepeatingCharWithStream_emptyInput_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> finder.findFirstRepeatingCharWithStream(""));
    }
}