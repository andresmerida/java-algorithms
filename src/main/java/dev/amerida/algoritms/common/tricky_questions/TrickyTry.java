package dev.amerida.algoritms.common.tricky_questions;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

public class TrickyTry {
    static void main(String[] args) {
        tryWithoutCatch();
        IO.println();

        IO.println(getNumber());
        IO.println();

        IO.println(getOverrideTry());
        IO.println();

        immutableArray();
    }

    public static void immutableArray() {
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
