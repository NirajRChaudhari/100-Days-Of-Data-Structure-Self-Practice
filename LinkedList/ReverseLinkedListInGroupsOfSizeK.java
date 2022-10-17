package LinkedList;

import LinkedList.SinglyLinkedList.Node;

public class ReverseLinkedListInGroupsOfSizeK extends OperationsOnSinglyLinkedList {

    public static void main(String[] args) {

        SinglyLinkedList linkedList = populateSinglyLinkedList();

        linkedList.print();

        System.out.println("\nEnter the value of k :");
        int k = sc.nextInt();

        linkedList.head = reverseLinkedListInGroupOfSizeK(linkedList.head, k);

        System.out.println("\nReversing LinkedList in group size of k ...");
        linkedList.print();
    }

    static Node reverseLinkedListInGroupOfSizeK(Node head, int k) {

        if (head == null) {
            return null;

        } else {

            Node currentNode = head, prevNode = null, prevGroupHead = head, currentGroupHead = head;

            // Starting Node counting with 1
            int index = 1;

            while (currentNode != null) {

                if (index % (k + 1) == 0) {

                    if (index == (k + 1)) {
                        head = prevNode;
                        currentGroupHead = currentNode;
                    } else {

                        prevGroupHead.next = prevNode;

                        prevGroupHead = currentGroupHead;
                        currentGroupHead = currentNode;
                    }
                } else {

                    Node nextNode = currentNode.next;
                    currentNode.next = prevNode;
                    prevNode = currentNode;
                    currentNode = nextNode;
                }

                index++;
            }

            // Last group's linking with previous list

            prevGroupHead.next = prevNode;
            currentGroupHead.next = null;

            return head;
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
