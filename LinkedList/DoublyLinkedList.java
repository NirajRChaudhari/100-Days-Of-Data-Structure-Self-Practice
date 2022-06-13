package LinkedList;

public class DoublyLinkedList {

    Node head;

    static class Node {
        int data;

        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    void printLeftToRight() {

        Node tempNode = head;

        System.out.println("\nLinked List's data Left to Right : ");

        if (tempNode == null) {
            return;
        }

        while (tempNode != null) {
            System.out.print(tempNode.data + " ");

            tempNode = tempNode.next;
        }
    }

    void printRightToLeft() {

        Node tempNode = head;

        System.out.println("\nLinked List's data Right to Left : ");

        if (tempNode == null) {
            return;
        }

        while (tempNode.next != null) {
            tempNode = tempNode.next;
        }

        while (tempNode != null) {
            System.out.print(tempNode.data + " ");

            tempNode = tempNode.prev;
        }

    }
}
