package dev.amerida.algoritms.leed_code.singly_linked_list.generic;

public class SinglyLinkedList<T> {
    private Node<T> head;

    public SinglyLinkedList() {
        this.head = null;
    }

    // Append at the beginning
    public void prepend(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
    }

    public void append(T data) {
        Node<T> newData = new Node<>(data);

        if (head == null) {
            head = newData;
            return;
        }

        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newData;
    }

    public void delete(T data) {
        if (head == null) {
            return;
        }

        if (head.data.equals(data)) {
            head = head.next;
            return;
        }

        Node<T> current = head;
        while (current.next != null && !current.next.data.equals(data)) {
            current = current.next;
        }

        if (current.next != null) { // if is null means not find element to delete
            current.next = current.next.next;
        }
    }

    public void display() {
        Node<T> current = head;
        while (current != null) {
            IO.print(current.data + " -> ");
            current = current.next;
        }
        IO.println("null");
    }

    // The node class must also be generic
    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    static void main() {
        IO.println("String SinglyList");
        SinglyLinkedList<String> wordList = new SinglyLinkedList<>();
        wordList.append("Apple");
        wordList.append("Banana");
        wordList.prepend("Mango");

        wordList.display();     // Output: Mango -> Apple -> Banana -> null
        wordList.delete("Apple");
        wordList.display();     // Output: Mango -> Banana -> null

        // or a list of integers
        SinglyLinkedList<Integer> numberList = new SinglyLinkedList<>();
        numberList.append(100);
        numberList.append(200);
        numberList.display();
    }
}
