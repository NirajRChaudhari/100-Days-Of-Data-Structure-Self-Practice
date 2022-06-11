package LinkedList;

public class CircularSinglyLinkedList {

    Node head;

    static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    void print() {

        Node tempHead = this.head;

        System.out.println("\nLinked List's data : ");

        if (tempHead == null) {
            return;
        }

        while (tempHead.next != head) {
            System.out.print(tempHead.data + " ");

            tempHead = tempHead.next;
        }

        System.out.print(tempHead.data + " ");

        System.out.println("\n");
    }
}
