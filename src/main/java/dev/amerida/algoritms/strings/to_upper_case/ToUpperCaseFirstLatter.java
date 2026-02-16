package dev.amerida.algoritms.strings.to_upper_case;

public class ToUpperCaseFirstLatter {

    public String convertToUppercaseEachFirstLatter(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("String cannot be null or empty");
        }

        String[] words = str.trim().split(" ");
        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            char firstLetter = word.charAt(0);
            sb.append(Character.toUpperCase(firstLetter)).append(word.substring(1));
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }
}
