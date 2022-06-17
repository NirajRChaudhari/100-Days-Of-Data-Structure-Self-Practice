package LinkedList;

import LinkedList.DoublyLinkedList.Node;

public class ReverseDoublyLinkedList extends OperationsOnDoublyLinkedList {

    public static void main(String[] args) {

        DoublyLinkedList linkedList = new DoublyLinkedList();
        int num;

        System.out.println("\n\n****** Insertion of Data in the Linked List *******");

        System.out.println("\nEnter the Number ");
        num = sc.nextInt();

        do {
            linkedList.head = insertAtStart(linkedList.head, num);

            linkedList.printLeftToRight();

            System.out.println("\n\n\nEnter the Number (-1 to Stop)");
            num = sc.nextInt();
        } while (num != -1);

        // Without creating any new Linked List :- O(1) Auxiliary Space
        linkedList.head = inPlaceReversedLinkedList(linkedList.head);

        // linkedList.head = reverseLinkedList(linkedList.head);

        System.out.println("\n\n***** Reversed Linked List ******");
        linkedList.printLeftToRight();

        System.out.println("\n\n");
    }

    static Node inPlaceReversedLinkedList(Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        Node prevNode = null;
        Node currentNode = head;

        while (currentNode != null) {

            currentNode.prev = currentNode.next;
            currentNode.next = prevNode;

            prevNode = currentNode;
            currentNode = currentNode.prev;
        }

        return prevNode;
    }

    static Node reverseLinkedList(Node head) {

        Node newHead = null;

        while (head != null) {

            Node tempNode = new Node(head.data);

            if (newHead == null) {
                newHead = tempNode;

            } else {
                tempNode.next = newHead;
                newHead.prev = tempNode;
                newHead = tempNode;
            }

            head = head.next;
        }

        return newHead;
    }
}
