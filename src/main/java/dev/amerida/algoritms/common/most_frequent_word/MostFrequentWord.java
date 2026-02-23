package dev.amerida.algoritms.common.most_frequent_word;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostFrequentWord {

    public String getMostFrequentWord(String paragraph, String[] bannedWords) {
        String paragraphNormalized = paragraph.replaceAll("[^a-zA-Z ]", "").toLowerCase();
        String[] words = paragraphNormalized.split(" ");

        Set<String> bannedWordsSet = new HashSet<>(Arrays.stream(bannedWords).map(String::toLowerCase).toList());

        Map<String, Integer> wordCountMap = new HashMap<>();
        for (String word : words) {
            if (!bannedWordsSet.contains(word)) {
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            }
        }

        return wordCountMap.entrySet().stream()
                .max((e1, e2) -> Integer.compare(e1.getValue(), e2.getValue()))
                .map(Map.Entry::getKey)
                .orElse("");
    }
}
