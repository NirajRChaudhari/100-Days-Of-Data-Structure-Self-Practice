package Searching;

public class IndexOfLastOccurrenceInSortedArray extends SearchingParentClass {

    public static void main(String[] args) {
        int[] array = getArray();

        int key = getNumber();

        // Efficient O(logN) based on binary search as array is sorted
        int index = findIndexOfLastOccurrence(array, key, 0, array.length - 1);

        // Naive iterative solution O(N)
        // int index = iterativeFindIndexOfLastOccurrence(array, key);

        if (index != -1) {
            System.out.println("\nElement " + key + " is present inside the array at index : " + index + "\n");
        } else {
            System.out.println("\nGiven element is NOT present inside the array\n");
        }
    }// main

    static int findIndexOfLastOccurrence(int[] array, int key, int left, int right) {

        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;

        if (key < array[mid]) {
            return findIndexOfLastOccurrence(array, key, left, mid - 1);

        } else if (key > array[mid]) {
            return findIndexOfLastOccurrence(array, key, mid + 1, right);

            // key = array[mid]
        } else {

            // Make sure current matched index is the righmost index or there is no same
            // number to the right of it in this sorted array
            if (mid == (array.length - 1) || array[mid + 1] != array[mid]) {
                return mid;

                // If there is same number to right of current index make recursive call to
                // right of mid
            } else {
                return findIndexOfLastOccurrence(array, key, mid + 1, right);
            }
        }

    }

    static int iterativeFindIndexOfLastOccurrence(int[] array, int key) {

        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == key) {
                return i;
            }
        }

        return -1;
    }
}
