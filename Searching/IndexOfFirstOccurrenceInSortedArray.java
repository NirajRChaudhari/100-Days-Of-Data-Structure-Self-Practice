package Searching;

public class IndexOfFirstOccurrenceInSortedArray extends SearchingParentClass {

    public static void main(String[] args) {

        System.out.println("\nFind first occurrence in Sorted Array \n");
        int[] array = getArray();

        int key = getNumber();

        // Efficient O(logN) based on binary search as array is sorted
        int index = findIndexOfFirstOccurrence(array, key, 0, array.length - 1);

        // Naive iterative solution O(N)
        // int index = iterativeFindIndexOfFirstOccurrence(array, key);

        if (index != -1) {
            System.out.println("\nElement " + key + " is present inside the array at index : " + index + "\n");
        } else {
            System.out.println("\nGiven element is NOT present inside the array\n");
        }
    }

    static int findIndexOfFirstOccurrence(int[] array, int key, int left, int right) {

        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;

        if (key < array[mid]) {
            return findIndexOfFirstOccurrence(array, key, left, mid - 1);

        } else if (key > array[mid]) {
            return findIndexOfFirstOccurrence(array, key, mid + 1, right);

            // key = array[mid]
        } else {

            // As array is sorted all the same numbers will be in a consecutive order so we
            // have to make sure that it's the leftmost index and similar number do not
            // exist in left of current index
            if (mid == 0 || array[mid - 1] != array[mid]) {
                return mid;

                // If similar element is present in left of current index make recursive call
                // for left half of mid
            } else {
                return findIndexOfFirstOccurrence(array, key, left, mid - 1);
            }
        }
    }

    static int iterativeFindIndexOfFirstOccurrence(int[] array, int key) {

        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                return i;
            }
        }

        return -1;
    }
}
