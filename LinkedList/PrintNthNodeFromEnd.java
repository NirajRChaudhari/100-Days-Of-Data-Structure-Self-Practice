package LinkedList;

import LinkedList.SinglyLinkedList.Node;

public class PrintNthNodeFromEnd extends OperationsOnSinglyLinkedList {

    public static void main(String[] args) {

        SinglyLinkedList linkedList = populateSinglyLinkedList();

        linkedList.print();

        System.out.println("\nEnter the position from End of the Node to be printed : ");
        int nthPos = sc.nextInt();

        printNthPositionInLinkedList(linkedList.head, nthPos);
    }

    static void printNthPositionInLinkedList(Node head, int nthPos) {

        Node slowNode = head, fastNode = head;

        System.out.println("\nNth Node from the end in the LinkedList is : ");

        if (head == null) {
            System.out.println("NULL\n");
        }

        for (int i = 0; i < nthPos - 1 && fastNode != null; i++) {
            fastNode = fastNode.next;
        }

        if (fastNode == null) {
            System.out.println("Invalid Position from the End\n");

        } else {

            while (fastNode.next != null) {
                fastNode = fastNode.next;
                slowNode = slowNode.next;
            }

            System.out.println(slowNode.data + "\n");
        }

    }

    static SinglyLinkedList populateSinglyLinkedList() {
        System.out.println("\nEnter Total number of Nodes in the LinkedList : ");
        int count = sc.nextInt();

        SinglyLinkedList linkedList = new SinglyLinkedList();

        for (int i = 0; i < count; i++) {
            System.out.println("\nEnter the value for Node " + i + " :");
            int num = sc.nextInt();

            linkedList.head = insertAtEnd(linkedList.head, num);
        }

        return linkedList;
    }
}
