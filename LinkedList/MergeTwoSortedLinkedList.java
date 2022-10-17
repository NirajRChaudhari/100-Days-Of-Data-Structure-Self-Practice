package LinkedList;

import LinkedList.SinglyLinkedList.Node;

public class MergeTwoSortedLinkedList extends OperationsOnSinglyLinkedList {

    public static void main(String[] args) {

        System.out.println("\n****** FIRST LINKED LIST ******");
        SinglyLinkedList linkedList1 = populateSortedSinglyLinkedList();
        linkedList1.print();

        System.out.println("\n****** SECOND LINKED LIST ******");
        SinglyLinkedList linkedList2 = populateSortedSinglyLinkedList();
        linkedList2.print();

        linkedList1.head = mergeTwoSortedLinkedLists(linkedList1.head, linkedList2.head);
        linkedList1.print();
    }

    static Node mergeTwoSortedLinkedLists(Node linkedList1Head, Node linkedList2Head) {

        SinglyLinkedList mergedSortedList = new SinglyLinkedList();

        Node tempNode1 = linkedList1Head, tempNode2 = linkedList2Head, mergedListNode = mergedSortedList.head;

        while (tempNode1 != null && tempNode2 != null) {
            if (tempNode1.data < tempNode2.data) {
                if (mergedListNode == null) {
                    mergedListNode = tempNode1;
                    mergedSortedList.head = mergedListNode;

                } else {
                    mergedListNode.next = tempNode1;
                    mergedListNode = mergedListNode.next;
                }
                tempNode1 = tempNode1.next;
                mergedListNode.next = null;

            } else {
                if (mergedListNode == null) {
                    mergedListNode = tempNode2;
                    mergedSortedList.head = mergedListNode;

                } else {
                    mergedListNode.next = tempNode2;
                    mergedListNode = mergedListNode.next;
                }
                tempNode2 = tempNode2.next;
                mergedListNode.next = null;
            }
        }

        if (tempNode1 != null) {
            mergedListNode.next = tempNode1;
        }

        if (tempNode2 != null) {
            mergedListNode.next = tempNode2;
        }

        return mergedSortedList.head;
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
