package dev.amerida.algoritms.leed_code.singly_linked_list;

public class SinglyLinkedList {
    private Node head;

    public SinglyLinkedList() {
        this.head = null;
    }

    // Add a new node at the beginning
    public void prepend(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Add a new node at the end
    public void append(int data) {
        Node newNode = new Node(data);

        if (head == null) {     // if the list is empty. The new node becomes the head.
            head = newNode;
            return;
        }

        // Traverse to the last node
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Delete it by value (Remove the first occurrence of the data)
    public void delete(int data) {
        if (head == null) {
            return;
        }

        if (head.data == data) {
            head = head.next;
            return;
        }

        // Traverse to find the node right before the one to be deleted
        Node current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }

        // if we found the node, skip over it to delete it
        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    // Display the list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.print("null");
        IO.println();
    }

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}
