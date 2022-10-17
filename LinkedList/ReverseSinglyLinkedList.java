package LinkedList;

import LinkedList.SinglyLinkedList.Node;

public class ReverseSinglyLinkedList extends OperationsOnSinglyLinkedList {

    public static void main(String[] args) {

        SinglyLinkedList linkedList = populateSinglyLinkedList();

        linkedList.print();

        // linkedList.head = reverseSinglyLinkedList(linkedList.head);

        Node lastNode = recursiveReverseSinglyLinkedList(linkedList, linkedList.head);
        // You have to set next of last node of reversed linkedList to Null
        lastNode.next = null;

        System.out.println("Post Reversal ...");
        linkedList.print();
    }

    static Node reverseSinglyLinkedList(Node head) {

        if (head == null) {
            return null;

        } else if (head.next == null) {
            return head;

        } else {

            Node prevNode = head, currNode = head.next;

            while (currNode != null) {

                Node nextNode = currNode.next;
                currNode.next = prevNode;

                if (prevNode == head) {
                    prevNode.next = null;
                }

                prevNode = currNode;
                currNode = nextNode;
            }

            return prevNode;
        }
    }

    static Node recursiveReverseSinglyLinkedList(SinglyLinkedList linkedList, Node currentNode) {

        if (currentNode.next == null) {
            linkedList.head = currentNode;
            return currentNode;
        }

        recursiveReverseSinglyLinkedList(linkedList, currentNode.next).next = currentNode;

        return currentNode;
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
