package Searching;

public class CountAllOnesInBinarySortedArray extends SearchingParentClass {

    public static void main(String[] args) {

        int[] array = getArray();

        System.out.println(
                "\nCount of all occurrences of 1 in the array is : "
                        + countOfAllOccurrencesOfOne(array, 0, array.length - 1));
    }

    // Find first occurrence of 1 and then all numbers till array length-1 will be 1
    // as it is sorted binary array
    static int countOfAllOccurrencesOfOne(int[] array, int left, int right) {
        if (left > right) {
            return 0;
        }

        int mid = (left + right) / 2;

        if (array[mid] == 0) {
            return countOfAllOccurrencesOfOne(array, mid + 1, right);

        } else {
            if (mid == 0 || array[mid - 1] != array[mid]) {
                return array.length - mid;
            } else {
                return countOfAllOccurrencesOfOne(array, left, mid - 1);
            }
        }
    }
}
