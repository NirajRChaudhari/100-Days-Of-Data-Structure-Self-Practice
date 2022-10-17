package LinkedList;

import LinkedList.SinglyLinkedList.Node;

public class SegregateEvenOddNodesInLinkedList extends OperationsOnSinglyLinkedList {

    public static void main(String[] args) {

        SinglyLinkedList linkedList = populateSinglyLinkedList();
        linkedList.print();

        System.out.println("\nPost Even Odd segregation of LinkedList : ");

        linkedList.head = evenOddSegregationInLinkedList(linkedList.head);
        linkedList.print();
    }

    static Node evenOddSegregationInLinkedList(Node head) {

        Node lastEvenNodeReference = null, prevNode = null, currentNode = head;

        if (head.data % 2 == 0) {
            lastEvenNodeReference = head;
            currentNode = currentNode.next;
        }

        // Here we are moving even nodes to start other approach can be to move all odd
        // nodes to end
        while (currentNode != null) {

            if (currentNode.data % 2 == 0) {

                if (prevNode != null) {
                    prevNode.next = currentNode.next;
                }

                if (lastEvenNodeReference == null) {
                    currentNode.next = head;
                    head = currentNode;
                    lastEvenNodeReference = head;

                } else {
                    currentNode.next = lastEvenNodeReference.next;
                    lastEvenNodeReference.next = currentNode;
                }
            }

            prevNode = currentNode;
            currentNode = currentNode.next;
        }

        return head;
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
