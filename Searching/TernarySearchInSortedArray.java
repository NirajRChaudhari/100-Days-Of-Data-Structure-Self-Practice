package Searching;

public class TernarySearchInSortedArray extends SearchingParentClass {

    public static void main(String[] args) {

        System.out.println("\nTernary search on Sorted Array\n");
        int[] array = getArray();

        int key = getNumber();

        int index = ternarySearch(array, key, 0, array.length - 1);

        if (index != -1) {
            System.out.println("\nElement " + key + " is present inside the array at index : " + index + "\n");
        } else {
            System.out.println("\nGiven element is NOT present inside the array\n");
        }
    }

    static int ternarySearch(int[] array, int key, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid1 = left + ((right - left) / 3);

        int mid2 = left + 2 * ((right - left) / 3);

        if (array[mid1] == key) {
            return mid1;
        }
        if (array[mid2] == key) {
            return mid2;
        }

        if (key < array[mid1]) {
            return ternarySearch(array, key, left, mid1 - 1);
        } else if (key > array[mid2]) {
            return ternarySearch(array, key, mid2 + 1, right);
        } else {
            return ternarySearch(array, key, mid1 + 1, mid2 - 1);
        }
    }

}
