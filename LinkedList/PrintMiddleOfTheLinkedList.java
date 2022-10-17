package LinkedList;

import LinkedList.SinglyLinkedList.Node;

public class PrintMiddleOfTheLinkedList extends OperationsOnSinglyLinkedList {

    public static void main(String[] args) {
        SinglyLinkedList linkedList = populateSinglyLinkedList();
        linkedList.print();

        printMiddleOfSinglyLinkedLis(linkedList);
    }

    static void printMiddleOfSinglyLinkedLis(SinglyLinkedList linkedList) {

        Node head = linkedList.head;

        System.out.println("\nMiddle Element of the Singly LinkedList is : ");

        if (head == null) {
            System.out.println("Null\n\n");
        } else {

            Node slowNode = head, fastNode = head;

            while (fastNode != null && fastNode.next != null) {
                slowNode = slowNode.next;

                fastNode = fastNode.next;
                if (fastNode != null) {
                    fastNode = fastNode.next;
                }
            }

            System.out.println(slowNode.data + "\n\n");
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
