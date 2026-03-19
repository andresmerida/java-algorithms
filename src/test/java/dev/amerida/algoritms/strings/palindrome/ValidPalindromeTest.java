package dev.amerida.algoritms.strings.palindrome;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidPalindromeTest {
    private final ValidPalindrome validator = new ValidPalindrome();

    // --- isPalindrome ---

    @Test
    void isPalindrome_simplePalindrome() {
        assertTrue(validator.isPalindrome("racecar"));
    }

    @Test
    void isPalindrome_withSpacesAndPunctuation() {
        assertTrue(validator.isPalindrome("A man, a plan, a canal: Panama"));
    }

    @Test
    void isPalindrome_notAPalindrome() {
        assertFalse(validator.isPalindrome("race a car"));
    }

    @Test
    void isPalindrome_emptyString_returnsTrue() {
        assertTrue(validator.isPalindrome(""));
    }

    @Test
    void isPalindrome_singleCharacter_returnsTrue() {
        assertTrue(validator.isPalindrome("a"));
    }

    @Test
    void isPalindrome_onlyNonAlphanumeric_returnsTrue() {
        assertTrue(validator.isPalindrome(" .,!"));
    }

    @Test
    void isPalindrome_mixedCase_returnsTrue() {
        assertTrue(validator.isPalindrome("AbBa"));
    }

    @Test
    void isPalindrome_withDigits() {
        assertTrue(validator.isPalindrome("12321"));
    }

    @Test
    void isPalindrome_alphanumericMixed() {
        assertTrue(validator.isPalindrome("A1b2b1A"));
    }

    @Test
    void isPalindrome_null_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> validator.isPalindrome(null));
    }

    // --- isPalindromeWithStringBuilder ---

    @Test
    void isPalindromeWithStringBuilder_simplePalindrome() {
        assertTrue(validator.isPalindromeWithStringBuilder("racecar"));
    }

    @Test
    void isPalindromeWithStringBuilder_withSpacesAndPunctuation() {
        assertTrue(validator.isPalindromeWithStringBuilder("A man, a plan, a canal: Panama"));
    }

    @Test
    void isPalindromeWithStringBuilder_notAPalindrome() {
        assertFalse(validator.isPalindromeWithStringBuilder("race a car"));
    }

    @Test
    void isPalindromeWithStringBuilder_emptyString_returnsTrue() {
        assertTrue(validator.isPalindromeWithStringBuilder(""));
    }

    @Test
    void isPalindromeWithStringBuilder_singleCharacter_returnsTrue() {
        assertTrue(validator.isPalindromeWithStringBuilder("a"));
    }

    @Test
    void isPalindromeWithStringBuilder_onlyNonAlphanumeric_returnsTrue() {
        assertTrue(validator.isPalindromeWithStringBuilder(" .,!"));
    }

    @Test
    void isPalindromeWithStringBuilder_mixedCase_returnsTrue() {
        assertTrue(validator.isPalindromeWithStringBuilder("AbBa"));
    }

    @Test
    void isPalindromeWithStringBuilder_withDigits() {
        assertTrue(validator.isPalindromeWithStringBuilder("12321"));
    }

    @Test
    void isPalindromeWithStringBuilder_alphanumericMixed() {
        assertTrue(validator.isPalindromeWithStringBuilder("A1b2b1A"));
    }

    @Test
    void isPalindromeWithStringBuilder_null_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> validator.isPalindromeWithStringBuilder(null));
    }
}