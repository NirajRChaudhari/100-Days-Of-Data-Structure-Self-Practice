package LinkedList;

import LinkedList.SinglyLinkedList.Node;

public class DeleteBetweenNodeUsingItsReferenceWithoutHeadReference extends OperationsOnSinglyLinkedList {

    public static void main(String[] args) {

        SinglyLinkedList linkedList = populateSinglyLinkedList();
        linkedList.print();

        System.out.println("\nEnter value of node between Start and End(Exclusive) to be deleted : ");
        int valueToDelete = sc.nextInt();

        Node deleteNodeReference = getReference(linkedList.head, valueToDelete);

        System.out.println("\nPost Deletion using Node " + valueToDelete + " reference ...");
        // Logic to delete any between start and end(exclusive) without head node
        // reference using only reference of node to be deleted
        deleteBetweenNodeUsingItsReference(deleteNodeReference);
        linkedList.print();
    }

    static void deleteBetweenNodeUsingItsReference(Node deleteNodeReference) {

        deleteNodeReference.data = deleteNodeReference.next.data;
        deleteNodeReference.next = deleteNodeReference.next.next;
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

    static Node getReference(Node head, int valueToDelete) {

        Node tempNode = head;

        while (tempNode != null) {
            if (tempNode.data == valueToDelete) {
                return tempNode;
            }
            tempNode = tempNode.next;
        }

        return null;
    }
}
