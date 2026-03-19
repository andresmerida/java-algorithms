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


    @Test
    void setFindFirstNotRepeatedChar3 () {
        String input = "aabbcdd";
        assertEquals('c', findFirstNotRepeatedChar.findFirstNotRepeatedChar3(input));

    }

    @Test
    void setFindFirstNotRepeatedCharFirst () {
        String input = "abbcdd";
        assertEquals('a', findFirstNotRepeatedChar.findFirstNotRepeatedChar3(input));

    }

    @Test
    void setFindFirstNotRepeatedCharLast() {
        String input = "aabbcccd";
        assertEquals('d', findFirstNotRepeatedChar.findFirstNotRepeatedChar3(input));

    }

    @Test
    void setFindFirstNotRepeatedCharNot() {
        String input = "aabbccc";
        assertEquals('\0', findFirstNotRepeatedChar.findFirstNotRepeatedChar3(input));

    }
}
