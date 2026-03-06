package dev.amerida.algoritms.strings.compression;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCompressionTest {
    private final StringCompression stringCompression = new StringCompression();

    @Test
    void compressString() {
        String input = "aaabbbccc";
        String expected = "a3b3c3";
        assertEquals(expected, stringCompression.compressString(input));
    }

    @Test
    void compressString_1() {
        String input = "a";
        String expected = "a1";
        assertEquals(expected, stringCompression.compressString(input));
    }

    @Test
    void compressString_2() {
        String input = "aabbc";
        String expected = "a2b2c1";
        assertEquals(expected, stringCompression.compressString(input));
    }

    @Test
    void compressString_null() {
        assertThrows(IllegalArgumentException.class, () -> stringCompression.compressString(null));
    }

    @Test
    void compressStringWithStream() {
        String input = "aaabbbccc";
        String expected = "a3b3c3";
        assertEquals(expected, stringCompression.compressStringWithStream(input));
    }

    @Test
    void compressStringWithStream1() {
        String input = "a";
        String expected = "a1";
        assertEquals(expected, stringCompression.compressStringWithStream(input));
    }

    @Test
    void compressStringWithStream2() {
        String input = "aabbc";
        String expected = "a2b2c1";
        assertEquals(expected, stringCompression.compressStringWithStream(input));
    }

    @Test
    void compressStringWithStream_null() {
        assertThrows(IllegalArgumentException.class, () -> stringCompression.compressStringWithStream(null));
    }
}