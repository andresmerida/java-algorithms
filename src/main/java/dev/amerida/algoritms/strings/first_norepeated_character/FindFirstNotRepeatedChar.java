package dev.amerida.algoritms.strings.first_norepeated_character;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindFirstNotRepeatedChar {

    public Optional<Character> findFirstNotRepeatedChar(String str) {
        if (str == null || str.isEmpty()) {
            return Optional.empty();
        }

        return str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst();
    }

    public char findFirstNotRepeatedChar2(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("String cannot be null or empty");
        }

        LinkedHashMap<Character, Long> linkedHashMap = new LinkedHashMap<>();
        for (char c : str.toCharArray()) {
            linkedHashMap.put(c, linkedHashMap.getOrDefault(c, 0L) + 1);
        }

        for (char c : linkedHashMap.keySet()) {
            if (linkedHashMap.get(c) == 1) {
                return c;
            }
        }

        return '\0';
    }
}
