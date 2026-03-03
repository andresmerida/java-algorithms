package dev.amerida.algoritms.strings.to_camel_case;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToCamelCaseTest {
    private final ToCamelCase toCamelCase = new ToCamelCase();

    @Test
    void convertToCamelCase() {
        String input = "heLLO worLD jAva";
        String expected = "helloWorldJava";
        assertEquals(expected, toCamelCase.convertToCamelCase(input));
    }

    @Test
    void convertToCamelCase_empty() {
        String input = "";
        String expected = "";
        assertEquals(expected, toCamelCase.convertToCamelCase(input));
    }

    @Test
    void convertToCamelCase_null() {
        assertThrows(IllegalArgumentException.class, () -> toCamelCase.convertToCamelCase(null));
    }
}