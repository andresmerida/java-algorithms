package dev.amerida.algoritms.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToUpperCaseFirstLatterTest {
    private final ToUpperCaseFirstLatter toUpperCaseFirstLatter = new ToUpperCaseFirstLatter();

    @Test
    void convertToUppercaseEachFirstLatter() {
        String str = "hello world bolivia";
        String expected = "Hello World Bolivia";
        assertEquals(expected, toUpperCaseFirstLatter.convertToUppercaseEachFirstLatter(str));
    }

    @Test
    void convertToUppercaseEachFirstLatter_space_at_init_and_end() {
        String str = " hello world bolivia ";
        String expected = "Hello World Bolivia";
        assertEquals(expected, toUpperCaseFirstLatter.convertToUppercaseEachFirstLatter(str));
    }

    @Test
    void convertToUppercaseEachFirstLatter_null() {
        assertThrows(IllegalArgumentException.class, () -> toUpperCaseFirstLatter.convertToUppercaseEachFirstLatter(null));
    }

    @Test
    void convertToUppercaseEachFirstLatter_empty() {
        assertThrows(IllegalArgumentException.class, () -> toUpperCaseFirstLatter.convertToUppercaseEachFirstLatter(""));
    }
}