package LinkedList;

import java.util.Scanner;

import LinkedList.CircularSinglyLinkedList.Node;

public class OperationsOnCircularSinglyLinkedList {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        CircularSinglyLinkedList linkedList = new CircularSinglyLinkedList();
        String choice;

        do {
            System.out.println("\n\n************ START MENU *************");

            System.out.println(
                    "\nSelect the Operation : \n1. Insertion\n2. Deletion\n3. Search");

            int operation = sc.nextInt();

            switch (operation) {
                case 1:
                    linkedList.head = insertionOperation(linkedList);
                    linkedList.print();
                    break;

                case 2:
                    linkedList.head = deletionOperation(linkedList);
                    linkedList.print();
                    break;

                case 3:
                    // searchOperation(linkedList);
            }

            System.out.println("Do you want to continue (Y/N) ? ");
            choice = sc.next();

        } while (choice.equals("y") || choice.equals("Y"));

    }

    // We can get O(1) time complexity for insertion at start and end if we store
    // tailNode instead of head
    static Node insertionOperation(CircularSinglyLinkedList linkedList) {
        System.out.println("\nEnter the Element to be inserted : ");
        int data = sc.nextInt();

        System.out.println(
                "\nSelect option where you want Insert the element : \n1. At the Start\n2. At the End\n3. In Between");

        int position = sc.nextInt();

        switch (position) {
            case 1:
                linkedList.head = insertAtStart(linkedList.head, data);
                break;

            case 2:
                linkedList.head = insertAtEnd(linkedList.head, data);
                break;

            case 3:
                System.out.println("\nEnter the index where element is to be added (Starts with 0) : ");
                int index = sc.nextInt();

                linkedList.head = insertInBetween(linkedList.head, data, index);
                break;
        }

        return linkedList.head;
    }

    static Node insertAtStart(Node head, int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            head.next = head;

        } else {

            Node tempNode = head;
            while (tempNode.next != head) {
                tempNode = tempNode.next;
            }

            tempNode.next = newNode;
            newNode.next = head;

            head = newNode;
        }

        return head;
    }

    static Node insertAtEnd(Node head, int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            head.next = head;

        } else {
            Node tempNode = head;
            while (tempNode.next != head) {
                tempNode = tempNode.next;
            }

            tempNode.next = newNode;
            newNode.next = head;
        }

        return head;
    }

    static Node insertInBetween(Node head, int data, int index) {

        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;

        } else if (index == 0) {
            head = insertAtStart(head, data);

        } else {
            Node tempNode = head;

            int i = 1;
            tempNode = tempNode.next;

            // If you start with first node tempNode != head will fail
            while (i < index && tempNode != head) {

                if (i == index - 1) {

                    newNode.next = tempNode.next;
                    tempNode.next = newNode;
                }

                i++;
                tempNode = tempNode.next;
            }
        }

        return head;
    }

    /*
     * If the scenario is to just delete the head node
     * 
     * O(N) approach :
     * Traverse to tail and removing tail.next which is head node
     * 
     * O(1) approach :
     * copying head.next to head and delete head.next
     */
    static Node deletionOperation(CircularSinglyLinkedList linkedList) {

        linkedList.print();

        System.out.println("\nEnter the Element to be deleted : ");
        int dataToDelete = sc.nextInt();

        Node head = linkedList.head;

        if (head == null) {
            return null;

        } else if (head.data == dataToDelete && head.next == head) {
            return null;

        } else {
            Node tempNode = head;

            while (tempNode.next != head) {

                if (tempNode.next.data == dataToDelete) {
                    tempNode.next = tempNode.next.next;
                }

                tempNode = tempNode.next;
            }

            // Control comes here when tempNode.next is head so check this position 0 for
            // dataToDelete
            if (tempNode.next.data == dataToDelete) {
                tempNode.next = tempNode.next.next;
                head = tempNode.next;
            }
        }

        return head;
    }
}
