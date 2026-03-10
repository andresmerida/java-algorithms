package dev.amerida.algoritms.strings.valid_parentheses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidParenthesesTest {
    private final ValidParentheses validParentheses = new ValidParentheses();

    // --- isValid ---

    @Test
    void isValid_simpleParentheses() {
        assertTrue(validParentheses.isValid("()"));
    }

    @Test
    void isValid_mixedBrackets() {
        assertTrue(validParentheses.isValid("()[]{}"));
    }

    @Test
    void isValid_nested() {
        assertTrue(validParentheses.isValid("{[()]}"));
    }

    @Test
    void isValid_mismatchedParentheses() {
        assertFalse(validParentheses.isValid("(]"));
    }

    @Test
    void isValid_unclosedBracket() {
        assertFalse(validParentheses.isValid("([)"));
    }

    @Test
    void isValid_onlyOpeningBrackets() {
        assertFalse(validParentheses.isValid("((("));
    }

    @Test
    void isValid_onlyClosingBrackets() {
        assertFalse(validParentheses.isValid("}}}"));
    }

    @Test
    void isValid_emptyString() {
        assertTrue(validParentheses.isValid(""));
    }

    // --- isValidParentheses ---

    @Test
    void isValidParentheses_simpleParentheses() {
        assertTrue(validParentheses.isValidParentheses("()"));
    }

    @Test
    void isValidParentheses_mixedBrackets() {
        assertTrue(validParentheses.isValidParentheses("()[]{}"));
    }

    @Test
    void isValidParentheses_nested() {
        assertTrue(validParentheses.isValidParentheses("{[()]}"));
    }

    @Test
    void isValidParentheses_mismatchedParentheses() {
        assertFalse(validParentheses.isValidParentheses("(]"));
    }

    @Test
    void isValidParentheses_unclosedBracket() {
        assertFalse(validParentheses.isValidParentheses("([)"));
    }

    @Test
    void isValidParentheses_onlyOpeningBrackets() {
        assertFalse(validParentheses.isValidParentheses("((("));
    }

    @Test
    void isValidParentheses_onlyClosingBrackets() {
        assertFalse(validParentheses.isValidParentheses("}}}"));
    }

    @Test
    void isValidParentheses_emptyString() {
        assertTrue(validParentheses.isValidParentheses(""));
    }
}