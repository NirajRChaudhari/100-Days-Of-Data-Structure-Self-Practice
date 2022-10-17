package LinkedList;

import LinkedList.SinglyLinkedList.Node;

public class RemoveDuplicatesFromSortedList extends OperationsOnSinglyLinkedList {

    public static void main(String[] args) {

        SinglyLinkedList linkedList = populateSortedSinglyLinkedList();
        linkedList.print();

        linkedList.head = removeDuplicatesFromSortedList(linkedList.head);

        System.out.println("\nAfter Removing Duplicates ...");
        linkedList.print();

    }

    static Node removeDuplicatesFromSortedList(Node head) {

        if (head == null) {
            return null;

        } else if (head.next == null) {
            return head;

        } else {

            Node prevNode = head, currentNode = head.next;

            while (currentNode != null) {

                if (currentNode.data == prevNode.data) {
                    // If current Node has to be deleted
                    prevNode.next = currentNode.next;

                    currentNode = prevNode.next;
                    // Prev node's position will remain same

                } else {
                    // Unique current element
                    currentNode = currentNode.next;
                    prevNode = prevNode.next;
                }
            }
        }

        return head;
    }

    static SinglyLinkedList populateSortedSinglyLinkedList() {
        System.out.println("\nEnter Total number of Nodes in the Sorted LinkedList : ");
        int count = sc.nextInt();

        SinglyLinkedList linkedList = new SinglyLinkedList();
        int prevNum = Integer.MIN_VALUE;

        for (int i = 0; i < count; i++) {
            System.out.println("\nEnter the value for Node " + i + " :");
            int num = sc.nextInt();

            if (num < prevNum) {
                System.out.println("Data NOT in the Sorted order!!\n");
                i--;

            } else {
                linkedList.head = insertAtEnd(linkedList.head, num);
                prevNum = num;
            }

        }

        return linkedList;
    }

}
