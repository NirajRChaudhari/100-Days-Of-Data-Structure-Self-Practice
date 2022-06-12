package LinkedList;

public class SinglyLinkedList {

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

        while (tempHead != null) {
            System.out.print(tempHead.data + " ");

            tempHead = tempHead.next;
        }
        System.out.println("\n");
    }
}
