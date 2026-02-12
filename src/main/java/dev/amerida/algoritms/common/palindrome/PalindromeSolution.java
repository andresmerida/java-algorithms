package dev.amerida.algoritms.common.palindrome;

/**
 * Palindromes are words, phrases, or sentences that read the same forward
 * and backward, ignoring spaces, punctuation, and capitalization.
 * Common examples include words like: radar, level, kayak, madam, and racecar
 * Famous phrase examples are:
 * "A man, a plan, a canal: Panama,"
 * "Madam, I'm Adam,"
 * "Was it a car or a cat I saw?"
 */
public class PalindromeSolution {

    public boolean isPalindromeWithReverse(String str) {
        if (str == null) {
            throw new IllegalArgumentException("String cannot be null");
        }
        if (str.isEmpty()) {
            return false;
        }
        // normalize allowed just a-z, A-Z, 0-9
        str = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        return str.contentEquals(new StringBuilder(str).reverse());
    }

    public boolean isPalindrome(String str) {
        if (str == null) {
            throw new IllegalArgumentException("String cannot be null");
        }
        if (str.isEmpty()) {
            return false;
        }

        // normalize allowed just a-z, A-Z, 0-9
        str = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                return false;
            }
        }

        return true;
    }
}
