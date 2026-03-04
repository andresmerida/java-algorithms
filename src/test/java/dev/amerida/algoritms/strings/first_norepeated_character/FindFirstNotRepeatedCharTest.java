package dev.amerida.algoritms.strings.first_norepeated_character;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class FindFirstNotRepeatedCharTest {
    private final FindFirstNotRepeatedChar findFirstNotRepeatedChar = new FindFirstNotRepeatedChar();

    @Test
    void findFirstNotRepeatedChar() {
        String input = "abacabad";
        if (findFirstNotRepeatedChar.findFirstNotRepeatedChar(input).isPresent()) {
            assertEquals('c', findFirstNotRepeatedChar.findFirstNotRepeatedChar(input).get());
        }

    }

    @Test
    void findFirstNotRepeatedChar_null() {
        String input = "aabbcc";
        assertEquals(Optional.empty(), findFirstNotRepeatedChar.findFirstNotRepeatedChar(input));
    }

    @Test
    void findFirstNotRepeatedChar2() {
        String input = "abacabad";
        assertEquals('c', findFirstNotRepeatedChar.findFirstNotRepeatedChar2(input));
    }

    @Test
    void findFirstNotRepeatedChar_cero() {
        String input = "aabbcc";
        assertEquals('\0', findFirstNotRepeatedChar.findFirstNotRepeatedChar2(input));
    }

    @Test
    void findFirstNotRepeatedChar_empty() {
        String input = "";
        assertThrows(IllegalArgumentException.class, () -> findFirstNotRepeatedChar.findFirstNotRepeatedChar2(input));
    }
}