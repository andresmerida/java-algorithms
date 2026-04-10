package dev.amerida.algoritms;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App {
    static void main( String[] args ) {
        System.out.println( "Hello World!" );
        String greeting = "Hello World!";
        String wordsNormalized = greeting.replaceAll("[^a-zA-z ]", "").toLowerCase();
        System.out.println(wordsNormalized);
        IO.println();
        String[] words = wordsNormalized.split(" ");
        IO.println(words.length);
        Arrays.stream(words).forEach(System.out::println);
    }
}
