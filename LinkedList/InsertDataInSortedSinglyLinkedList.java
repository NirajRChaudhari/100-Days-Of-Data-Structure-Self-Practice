package LinkedList;

import LinkedList.SinglyLinkedList.Node;

public class InsertDataInSortedSinglyLinkedList extends OperationsOnSinglyLinkedList {

    public static void main(String[] args) {

        SinglyLinkedList linkedList = populateSortedSinglyLinkedList();
        linkedList.print();

        char choice = 'N';

        do {
            System.out.println("\nEnter the value to be inserted in the Sorted LinkedList :");
            int data = sc.nextInt();

            linkedList.head = insertInSortedSinglyLinkedList(linkedList.head, data);
            linkedList.print();

            System.out.println("Do you want to continue(Y/N) ?");
            choice = sc.next().charAt(0);
            System.out.println("\n");
        } while (choice == 'y' || choice == 'Y');
    }

    static Node insertInSortedSinglyLinkedList(Node head, int data) {

        Node newNode = new Node(data);

        if (head == null) {
            return newNode;

        } else {

            Node prevNode = null, tempNode = head;

            while (tempNode != null) {

                if (data < tempNode.data) {

                    if (prevNode == null) {
                        // It means data has to be inserted at head position

                        newNode.next = tempNode;
                        head = newNode;

                    } else {
                        // Insert in between

                        prevNode.next = newNode;
                        newNode.next = tempNode;
                    }

                    return head;
                }

                prevNode = tempNode;
                tempNode = tempNode.next;
            } // while

            // Insert at end
            prevNode.next = newNode;
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
