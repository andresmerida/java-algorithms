package dev.amerida.algoritms.leed_code.string_decoder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringDecoderTest {
    private final StringDecoder stringDecoder = new StringDecoder();

    @Test
    void decode_201012() {
        String input = "--.-..-.--";
        String expected = "201012";
        assertEquals(expected, stringDecoder.decode(input));
    }

    @Test
    void decode_012() {
        String input = ".-.--";
        String expected = "012";
        assertEquals(expected, stringDecoder.decode(input));
    }

    @Test
    void decode_102() {
        String input = "-..--";
        String expected = "102";
        assertEquals(expected, stringDecoder.decode(input));
    }

    @Test
    void decode_210() {
        String input = "---..";
        String expected = "210";
        assertEquals(expected, stringDecoder.decode(input));
    }

    @Test
    void decode_120() {
        String input = "-.--.";
        String expected = "120";
        assertEquals(expected, stringDecoder.decode(input));
    }

    @Test
    void decode_ThrowException() {
        assertThrows(IllegalArgumentException.class, () -> stringDecoder.decode(".--df"));
    }

    @Test
    void decode2_012() {
        String input = ".-.--";
        String expected = "012";
        assertEquals(expected, stringDecoder.decodeClever(input));
    }

    @Test
    void decode2_102() {
        String input = "-..--";
        String expected = "102";
        assertEquals(expected, stringDecoder.decodeClever(input));
    }

    @Test
    void decode2_210() {
        String input = "---..";
        String expected = "210";
        assertEquals(expected, stringDecoder.decodeClever(input));
    }

    @Test
    void decode2_120() {
        String input = "-.--.";
        String expected = "120";
        assertEquals(expected, stringDecoder.decodeClever(input));
    }
}