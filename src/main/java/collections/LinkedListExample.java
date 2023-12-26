package collections;

import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {


        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 45; i < 67; i += 2) {
            linkedList.add(i);
        }
        System.out.println("Original Linkedlist " + linkedList);
        linkedList.remove(6);
        System.out.println("After removing item at index 6" + linkedList);

        LinkedList<Integer> anotherLinkedList = new LinkedList<>();
        for (int i = 200; i < 210; i++) {
            anotherLinkedList.add(i);
        }

        System.out.println("Another linked list " + anotherLinkedList);
        linkedList.addAll(anotherLinkedList);
        System.out.println("After adding another linked list " + linkedList);

    }
}
