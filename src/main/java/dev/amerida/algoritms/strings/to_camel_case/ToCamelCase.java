package dev.amerida.algoritms.strings.to_camel_case;

public class ToCamelCase {

    public String convertToCamelCase(String str) {
        if (str == null) {
            throw new IllegalArgumentException("String cannot be null");
        }

        if (str.isEmpty()) {
            return "";
        }

        String[] wordsNormalized = str.toLowerCase().split("\\s+");
        StringBuilder camelCase = new StringBuilder(wordsNormalized[0]);

        for (int i = 1; i < wordsNormalized.length; i++) {
            camelCase.append(wordsNormalized[i].substring(0, 1).toUpperCase())
                    .append(wordsNormalized[i].substring(1));
        }

        return camelCase.toString();
    }
}
