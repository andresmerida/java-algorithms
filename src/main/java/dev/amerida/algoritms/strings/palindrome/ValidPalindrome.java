package dev.amerida.algoritms.strings.palindrome;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        if (s == null) {
            throw new IllegalArgumentException("String cannot be null");
        }

        int leftIndex = 0;
        int rightIndex = s.length() - 1;
        while (leftIndex < rightIndex) {
            if (!Character.isLetterOrDigit(s.charAt(leftIndex))) {
                leftIndex++;
            } else if (!Character.isLetterOrDigit(s.charAt(rightIndex))) {
                rightIndex--;
            } else {
                if (Character.toLowerCase(s.charAt(leftIndex)) != Character.toLowerCase(s.charAt(rightIndex))) {
                    return false;
                }
                leftIndex++;
                rightIndex--;
            }
        }

        return true;
    }

    public boolean isPalindromeWithStringBuilder(String s) {
        if (s == null) {
            throw new IllegalArgumentException("String cannot be null");
        }

        String sNormalized = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        return new StringBuilder(sNormalized)
                .reverse()
                .toString()
                .equals(sNormalized);
    }
}
