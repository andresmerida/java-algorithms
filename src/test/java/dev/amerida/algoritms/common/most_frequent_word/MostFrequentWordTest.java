package dev.amerida.algoritms.common.most_frequent_word;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MostFrequentWordTest {
    private final MostFrequentWord mostFrequentWord = new MostFrequentWord();

    @Test
    void getMostFrequentWord() {
        String input = "Hola, andres merida. escobar_, hola andres como estas, tu apllido es merida, hola andres, andres";
        String[] bannedWords = {"andres", "tu"};
        String expected = "hola";
        assertEquals(expected, mostFrequentWord.getMostFrequentWord(input, bannedWords));
    }
}