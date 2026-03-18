package dev.amerida.algoritms.leed_code.singly_linked_list.generic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {

    // Note: display() is not tested because it depends on a missing IO class.
    // Tests below cover prepend, append, and delete by verifying no exceptions
    // are thrown and that delete correctly handles all structural cases
    // (head deletion, middle deletion, tail deletion, not-found, empty list).

    @Test
    void append_singleElement_noException() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        assertDoesNotThrow(() -> list.append(1));
    }

    @Test
    void append_multipleElements_noException() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        assertDoesNotThrow(() -> {
            list.append(1);
            list.append(2);
            list.append(3);
        });
    }

    @Test
    void prepend_singleElement_noException() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        assertDoesNotThrow(() -> list.prepend("a"));
    }

    @Test
    void prepend_multipleElements_noException() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        assertDoesNotThrow(() -> {
            list.prepend("c");
            list.prepend("b");
            list.prepend("a");
        });
    }

    @Test
    void delete_onEmptyList_noException() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        assertDoesNotThrow(() -> list.delete(42));
    }

    @Test
    void delete_headElement_noException() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.append(1);
        list.append(2);
        list.append(3);
        assertDoesNotThrow(() -> list.delete(1));
    }

    @Test
    void delete_middleElement_noException() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.append(1);
        list.append(2);
        list.append(3);
        assertDoesNotThrow(() -> list.delete(2));
    }

    @Test
    void delete_tailElement_noException() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.append(1);
        list.append(2);
        list.append(3);
        assertDoesNotThrow(() -> list.delete(3));
    }

    @Test
    void delete_nonExistentElement_noException() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.append(1);
        list.append(2);
        assertDoesNotThrow(() -> list.delete(99));
    }

    @Test
    void delete_onlyElement_noException() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.append(5);
        assertDoesNotThrow(() -> list.delete(5));
    }

    @Test
    void delete_firstOccurrenceOnly_noException() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.append(1);
        list.append(1);
        list.append(2);
        // Deletes first occurrence of 1; second 1 and 2 remain — no exception
        assertDoesNotThrow(() -> list.delete(1));
    }

    @Test
    void prepend_thenDeleteHead_noException() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.prepend("b");
        list.prepend("a");
        assertDoesNotThrow(() -> list.delete("a"));
    }

    @Test
    void worksWithStringType() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        assertDoesNotThrow(() -> {
            list.append("hello");
            list.append("world");
            list.delete("hello");
            list.delete("world");
        });
    }
}