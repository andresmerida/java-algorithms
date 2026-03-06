package dev.amerida.algoritms.strings.compression;

import java.util.function.Function;
import java.util.stream.Collectors;

public class StringCompression {

    public String compressString(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("String cannot be null or empty");
        }
        char[] chars = str.toCharArray();
        char currentChar = chars[0];
        int counter = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < chars.length; i++) {
            if (currentChar != chars[i]) {
                sb.append(currentChar).append(counter);
                currentChar = chars[i];
                counter = 1;
            } else {
                counter++;
            }
        }
        sb.append(currentChar).append(counter);

        return sb.toString();
    }

    public Object compressStringWithStream(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("String cannot be null or empty");
        }

        return str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .map(entry -> String.valueOf(entry.getKey()) + entry.getValue())
                .collect(Collectors.joining());
    }
}
