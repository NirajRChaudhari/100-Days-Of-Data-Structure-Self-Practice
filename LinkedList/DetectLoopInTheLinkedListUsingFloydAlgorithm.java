package LinkedList;

import LinkedList.SinglyLinkedList.Node;

public class DetectLoopInTheLinkedListUsingFloydAlgorithm extends OperationsOnSinglyLinkedList {

    public static void main(String[] args) {

        SinglyLinkedList linkedList = populateSinglyLinkedListWithLoop();

        if (checkIfLinkedListHasLoop(linkedList)) {
            System.out.println("\nLoop detected in the given LinkedList.\n");

        } else {
            System.out.println("\nGiven LinkedList doesn't have a Loop.\n");
        }
    }

    static boolean checkIfLinkedListHasLoop(SinglyLinkedList linkedList) {

        Node slowNode = linkedList.head, fastNode = linkedList.head;

        do {
            slowNode = slowNode.next;

            fastNode = fastNode.next;
            if (fastNode != null) {
                fastNode = fastNode.next;
            }

        } while ((slowNode != fastNode) && fastNode != null);

        if (fastNode == null) {
            return false;
        }

        return true;
    }

    static SinglyLinkedList populateSinglyLinkedListWithLoop() {
        System.out.println("\nEnter Total number of Nodes in the LinkedList : ");
        int count = sc.nextInt();

        SinglyLinkedList linkedList = new SinglyLinkedList();

        for (int i = 0; i < count; i++) {
            System.out.println("\nEnter the value for Node " + i + " :");
            int num = sc.nextInt();

            linkedList.head = insertAtEnd(linkedList.head, num);
        }

        System.out.println("\nLoop End Node to which value (-1 for No Loop) : ");
        int loopToData = sc.nextInt();

        if (loopToData != -1) {
            linkedList.head = addLoop(linkedList.head, loopToData);
        }

        return linkedList;
    }

    static Node addLoop(Node head, int loopToData) {

        Node tempNode = head, tailNode = null;

        while (tempNode.next != null) {
            tempNode = tempNode.next;
        }

        tailNode = tempNode;

        tempNode = head;
        while (tempNode != null) {

            if (tempNode.data == loopToData) {
                tailNode.next = tempNode;
                break;
            }
            tempNode = tempNode.next;
        }

        return head;
    }
}
