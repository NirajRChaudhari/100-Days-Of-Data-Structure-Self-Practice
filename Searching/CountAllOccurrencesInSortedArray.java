package Searching;

public class CountAllOccurrencesInSortedArray extends SearchingParentClass {

    public static void main(String[] args) {

        int[] array = getArray();

        int key = getNumber();

        System.out.println(
                "\nCount of all occurrences of " + key + " in the array is : "
                        + countOfAllOccurrences(array, key, 0, array.length - 1));

        // More efficient approach O(logN) calculate firstOccurrence and lastOccurence
        // of given number and subtract them to get total occurrences
        System.out.println(
                "\nCount of all occurrences of " + key + " in the array is : "
                        + efficientCountOfAllOccurrences(array, key));
    }

    static int countOfAllOccurrences(int[] array, int key, int left, int right) {

        if (left > right) {
            return 0;
        }

        int count = 0;
        int mid = (left + right) / 2;

        if (array[mid] == key) {
            count = 1;
        }

        return count + countOfAllOccurrences(array, key, left, mid - 1)
                + countOfAllOccurrences(array, key, mid + 1, right);

    }

    static int efficientCountOfAllOccurrences(int[] array, int key) {

        // Gives firstIndex in O(logN)
        int firstIndex = findIndexOfFirstOccurrence(array, key, 0, array.length - 1);

        // Element is not present so return 0
        if (firstIndex == -1) {
            return 0;
        }

        // Gives lastIndex in O(logN)
        int lastIndex = findIndexOfLastOccurrence(array, key, 0, array.length - 1);

        return (lastIndex - firstIndex + 1);
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
    }// firstOccurrence

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
    }// lastOccurrence
}
