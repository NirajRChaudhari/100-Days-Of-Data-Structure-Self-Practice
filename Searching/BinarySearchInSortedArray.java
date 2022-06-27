package Searching;

public class BinarySearchInSortedArray extends SearchingParentClass {

    public static void main(String[] args) {

        System.out.println("\nBinary Search on Sorted Array\n");
        int[] array = getArray();

        int key = getNumber();

        // Recursive Binary Search
        int index = binarySearch(array, key, 0, array.length - 1);

        // Iterative Binary Search
        // int index = iterativeBinarySearch(array, key);

        if (index != -1) {
            System.out.println("\nElement " + key + " is present inside the array at index : " + index + "\n");
        } else {
            System.out.println("\nGiven element is NOT present inside the array\n");
        }
    }

    static int binarySearch(int[] array, int key, int left, int right) {

        if (left > right) {
            return -1;
        }

        // mid = left + (right-left)/2
        int mid = (left + right) / 2;

        if (array[mid] == key) {
            return mid;
        } else if (key < array[mid]) {
            return binarySearch(array, key, left, mid - 1);
        } else {
            return binarySearch(array, key, mid + 1, right);
        }
    }

    static int iterativeBinarySearch(int[] array, int key) {
        int left = 0, right = array.length - 1;

        while (left <= right) {

            // mid = left + (right-left)/2
            int mid = (left + right) / 2;

            if (array[mid] == key) {
                return mid;
            }

            if (key < array[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
