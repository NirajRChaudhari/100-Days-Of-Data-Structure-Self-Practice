package LinkedList;

import java.util.Hashtable;

import LinkedList.DoublyLinkedList.Node;

public class LRUCacheImplementation extends OperationsOnDoublyLinkedList {

    /*
     * capacity = Cache and HashTable
     * size = LinkedList's current length
     */
    static int capacity = 0, size = 0;

    public static void main(String[] args) {

        char choice = 'N';

        System.out.println("\nEnter the capacity of the Cache : ");
        capacity = sc.nextInt();

        Hashtable<Integer, Node> hashtable = new Hashtable<>(capacity);

        DoublyLinkedList cacheLinkedList = new DoublyLinkedList();

        do {
            System.out.println("\nEnter the Data : ");
            int data = sc.nextInt();

            cacheLinkedList.head = fetchAndUpdateDataInCache(data, cacheLinkedList.head, hashtable);

            cacheLinkedList.printLeftToRight();

            sc.nextLine();

            System.out.println("\n\nDo you want to continue (Y/N) ? ");
            choice = sc.nextLine().charAt(0);
            System.out.println("\n");
        } while (choice == 'y' || choice == 'Y');

    }// main

    static Node fetchAndUpdateDataInCache(int data, Node cacheHead,
            Hashtable<Integer, Node> hashtable) {

        if (cacheHead == null) {
            System.out.println("\nCache Miss ...");

            cacheHead = new Node(data);
            hashtable.put(data, cacheHead);

            size++;

            return cacheHead;
        }

        Node dataCurrentNode = hashtable.get(data);

        if (dataCurrentNode != null) {
            System.out.println("\nCache Hit ...");

            // New Data node is already at head so no need to update
            if (dataCurrentNode.prev != null) {

                Node prevNode = dataCurrentNode.prev;
                prevNode.next = dataCurrentNode.next;

                if (dataCurrentNode.next != null) {
                    dataCurrentNode.next.prev = prevNode;
                }

                // Update the current Data node to head
                dataCurrentNode.next = cacheHead;
                cacheHead.prev = dataCurrentNode;

                cacheHead = dataCurrentNode;
            }

        } else {
            System.out.println("\nCache Miss ...");

            // Capacity is full so remove least used data and add new data node
            if (size == capacity) {
                Node tempNode = cacheHead;

                // Remove last node from Linked List
                while (tempNode.next.next != null) {
                    tempNode = tempNode.next;
                }
                hashtable.remove((int) tempNode.next.data);
                tempNode.next = null;

                size--;
            }

            // Directly add the data node in cache Linked List
            Node newNode = new Node(data);

            newNode.next = cacheHead;
            cacheHead.prev = newNode;
            cacheHead = newNode;

            // Update HashTable
            hashtable.put(data, newNode);

            size++;
        }

        return cacheHead;
    }
}
