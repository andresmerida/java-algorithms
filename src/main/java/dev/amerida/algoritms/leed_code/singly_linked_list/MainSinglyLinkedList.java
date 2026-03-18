package dev.amerida.algoritms.leed_code.singly_linked_list;

public class MainSinglyLinkedList {
    static void main() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.append(10);
        list.append(20);
        list.prepend(5);
        list.append(30);

        IO.println("Initial list: ");
        list.display(); // Output: 5 -> 10 -> 20 -> 30 -> null

        list.delete(20);
        IO.println("After deleting 20: ");
        list.display(); // Output: 5 -> 10 -> 30 -> null
    }
}
