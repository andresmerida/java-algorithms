package dev.amerida.algoritms.common.palindrome;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeSolutionTest {
    private final PalindromeSolution palindromeSolution = new PalindromeSolution();

    @Test
    void isPalindromeWithReverse() {
        String input = "racecar";
        assertTrue(palindromeSolution.isPalindromeWithReverse(input));
    }

    @Test
    void isPalindromeWithReverse_phrases() {
        String input = "A man, a plan, a canal: Panama,";
        assertTrue(palindromeSolution.isPalindromeWithReverse(input));
    }

    @Test
    void isPalindromeWithReverse_empty() {
        assertFalse(palindromeSolution.isPalindromeWithReverse(""));
    }

    @Test
    void isPalindromeWithReverse_null() {
        assertThrows(IllegalArgumentException.class, () -> palindromeSolution.isPalindromeWithReverse(null));
    }

    @Test
    void isPalindrome() {
        String input = "racecar";
        assertTrue(palindromeSolution.isPalindrome(input));
    }

    @Test
    void isPalindrome_phrases() {
        String input = "A man, a plan, a canal: Panama,";
        assertTrue(palindromeSolution.isPalindrome(input));
    }

    @Test
    void isPalindrome_empty() {
        assertFalse(palindromeSolution.isPalindrome(""));
    }

    @Test
    void isPalindrome_null() {
        assertThrows(IllegalArgumentException.class, () -> palindromeSolution.isPalindrome(null));
    }
}