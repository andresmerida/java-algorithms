package dev.amerida.algoritms.strings.most_frequent_word;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MostFrequentWord {

    public String getMostFrequentWord(String input) {
        String[] words = input.split("\\s+");

        Map<String, Integer> frequenceMap = new HashMap<>();
        String mostFrequentWord = "";
        int maxCount = 0;

        for (String word : words) {
            int count = frequenceMap.getOrDefault(word, 0) + 1;
            frequenceMap.put(word, count);

            if (count > maxCount) {
                maxCount = count;
                mostFrequentWord = word;
            }
        }

        return mostFrequentWord;
    }

    public String getMostFrequentWordWithStream(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty");
        }
        String[] words = input.split("\\s+");

        return Arrays.stream(words)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }
}
