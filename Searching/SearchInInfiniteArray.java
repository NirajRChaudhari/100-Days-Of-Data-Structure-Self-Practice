package Searching;

//Known as UNBOUNDED BINARY SEARCH
//Search in Infinite Array means array with very very large pool of data where array.length is unknown so we cannot call traditional binary search algorithm
public class SearchInInfiniteArray extends SearchingParentClass {

    public static void main(String[] args) {

        // Here we will imitate infinite array with normal array only considering that
        // array.length is unknown
        int[] array = getArray();

        int key = getNumber();

        findElementInInfiniteArray(array, key);
    }

    static int findElementInInfiniteArray(int[] array, int key) {

        int i = 2;

        while (true) {

            if (key == array[i]) {
                return i;
            }

            if (key < array[i]) {
                return binarySearch(array, key, i / 2, i);
            }

            i = i * 2;
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
}
