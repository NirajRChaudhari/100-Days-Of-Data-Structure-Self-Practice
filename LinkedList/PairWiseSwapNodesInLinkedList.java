package LinkedList;

import LinkedList.SinglyLinkedList.Node;

public class PairWiseSwapNodesInLinkedList extends OperationsOnSinglyLinkedList {

    public static void main(String[] args) {

        SinglyLinkedList linkedList = populateSinglyLinkedList();
        linkedList.print();

        // linkedList.head = pairWiseSwapNodesUsingData(linkedList.head);

        linkedList.head = pairWiseSwapNodesUsingReference(linkedList.head);
        linkedList.print();
    }

    static Node pairWiseSwapNodesUsingData(Node head) {

        // No swap needed for null or single node
        if (head == null || head.next == null) {
            return head;
        }

        Node prevNode = head, currentNode = head.next;

        while (currentNode != null) {

            int data = prevNode.data;
            prevNode.data = currentNode.data;
            currentNode.data = data;

            prevNode = currentNode.next;

            if (currentNode.next == null) {
                break;
            }
            currentNode = currentNode.next.next;
        }

        return head;
    }

    static Node pairWiseSwapNodesUsingReference(Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        Node prevNode = head, tempNode = head.next;

        // Swap inital 2 nodes (1st pair)
        prevNode.next = tempNode.next;
        tempNode.next = prevNode;
        head = tempNode;

        Node startNodeOfPair = head.next.next;
        // Previous node will be end node of previous pair
        prevNode = head.next;

        while (startNodeOfPair != null && startNodeOfPair.next != null) {

            prevNode.next = startNodeOfPair.next;
            startNodeOfPair.next = startNodeOfPair.next.next;
            prevNode.next.next = startNodeOfPair;

            // Update Pointers for next pair
            prevNode = startNodeOfPair;
            startNodeOfPair = startNodeOfPair.next;
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
