package dev.amerida.algoritms.strings.reverse_each_word_sentence;

public class ReverseEachWord {
    public String reverseWords(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("String cannot be null or empty");
        }
        char[] chars = str.toCharArray();
        int start = 0;
        for (int end = 0; end <= chars.length; end++) {
            if (end == chars.length || chars[end] == ' ') {
                reverse(chars, start, end - 1);
                start = end + 1;
            }
        }

        return new String(chars);
    }

    public String reverseWordsWithStringBuilder(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("String cannot be null or empty");
        }
        StringBuilder sbReverseWords = new StringBuilder();
        for (String word : str.split(" ")) {
            StringBuilder sb = new StringBuilder(word);
            sb.reverse();
            sbReverseWords.append(sb).append(" ");
        }

        return sbReverseWords.toString().trim();
    }

    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}
