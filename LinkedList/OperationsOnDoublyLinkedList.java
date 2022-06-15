package LinkedList;

import java.util.Scanner;

import LinkedList.DoublyLinkedList.Node;

public class OperationsOnDoublyLinkedList {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        DoublyLinkedList linkedList = new DoublyLinkedList();
        String choice;

        do {
            System.out.println("\n\n************ START MENU *************");

            System.out.println(
                    "\nSelect the Operation : \n1. Insertion\n2. Deletion\n3. Search");

            int operation = sc.nextInt();

            switch (operation) {
                case 1:
                    linkedList.head = insertionOperation(linkedList);
                    linkedList.printLeftToRight();
                    linkedList.printRightToLeft();
                    break;

                case 2:
                    linkedList.head = deletionOperation(linkedList);
                    linkedList.printLeftToRight();
                    linkedList.printRightToLeft();
                    break;

                case 3:
                    searchOperation(linkedList);
            }

            System.out.println("\nDo you want to continue (Y/N) ? ");
            choice = sc.next();

        } while (choice.equals("y") || choice.equals("Y"));
    }// main

    static Node insertionOperation(DoublyLinkedList linkedList) {

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

        } else {

            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        return head;
    }

    static Node insertAtEnd(Node head, int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;

        } else {

            Node tempNode = head;

            while (tempNode.next != null) {
                tempNode = tempNode.next;
            }

            tempNode.next = newNode;
            newNode.prev = tempNode;
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

            int i = 0;
            while (i < index && tempNode != null) {

                if (i == index - 1) {

                    // Case when element has to added at end
                    if (tempNode.next == null) {

                        tempNode.next = newNode;
                        newNode.prev = tempNode;

                    } else {
                        newNode.next = tempNode.next;
                        tempNode.next.prev = newNode;
                        tempNode.next = newNode;
                        newNode.prev = tempNode;
                    }

                    break;
                }

                tempNode = tempNode.next;
                i++;
            }

        }

        return head;
    }

    static Node deletionOperation(DoublyLinkedList linkedList) {

        Node head = linkedList.head;

        linkedList.printLeftToRight();
        System.out.println("\nEnter the Element to be deleted : ");
        int dataToDelete = sc.nextInt();

        if (head == null) {
            return null;

        } else if (head.data == dataToDelete) {
            head = head.next;

            if (head != null) {
                head.prev = null;
            }

        } else {

            Node tempNode = head;

            while (tempNode.next != null) {

                if (tempNode.next.data == dataToDelete) {

                    if (tempNode.next.next != null) {
                        tempNode.next.next.prev = tempNode;
                    }

                    tempNode.next = tempNode.next.next;
                    break;
                }

                tempNode = tempNode.next;
            }
        }

        return head;
    }

    static void searchOperation(DoublyLinkedList linkedList) {

        Node tempNode = linkedList.head;

        if (tempNode == null) {
            System.out.println("\nLinked List is Empty \n");

        } else {

            System.out.println("\nEnter the Data to be searched in Linked List:");
            int dataToSearch = sc.nextInt();

            int i = 0;
            while (tempNode != null) {

                if (tempNode.data == dataToSearch) {
                    System.out.println("\nData " + dataToSearch + " is present at index : " + i + "\n");
                    return;
                }

                i++;
                tempNode = tempNode.next;
            }

            System.out.println("\nGiven data NOT present in the Linked List\n");
        }
    }
}
