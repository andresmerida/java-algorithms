package dev.amerida.algoritms.common.tricky_questions;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

public class TrickyTry {
    static void main(String[] args) {
        tryWithoutCatch();
        IO.println();

        IO.println(getNumber());
        IO.println();

        IO.println(getOverrideTry());
        IO.println();

        arrayModificationWithConcurrentModificationException();
        IO.println();

        arrayModification();

        String str = null;
        switch (str) {
            case null -> IO.println("null");
            case "a" -> IO.println("a");
            default -> IO.println("default");
        }
    }

    private static void arrayModificationWithConcurrentModificationException() {
        try {
            List<String> list = new ArrayList<>(List.of("a", "b", "c"));
            for (String s : list) {
                list.remove(s);
            }
        } catch (ConcurrentModificationException e) {
            IO.println("ConcurrentModificationException");
            IO.println(e.getMessage());
        }
    }

    private static void arrayModification() {
        List<String> list = new ArrayList<>(List.of("a", "b", "c"));
        list.removeIf(element -> element.equals("b"));
        IO.println(list);
    }

    public static void tryWithoutCatch() {
        try {
            IO.println("Inside try block");
        } finally {
            IO.println("Inside finally block");
        }
    }

    public static int getNumber() {
        try {
            return 1;
        } finally {
            return 2;
        }
    }

    public static int getOverrideTry() {
        int x = 0;
        try {
            return x;
        } finally {
            x = 2;
        }
    }

}
