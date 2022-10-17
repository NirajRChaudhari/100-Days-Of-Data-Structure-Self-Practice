package Arrays;

public class RemoveDuplicateElementsInSortedArray extends ArrayParentClass {

    public static void main(String[] args) {
        int array[] = getArray();

        System.out.println("\n\nProcessing ...\n");

        // Call only 1 function at a time as the array is getting updated here
        // approachOne(array);

        approachTwo(array);
    }

    static void approachOne(int[] array) {

        int res = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[res - 1] != array[i]) {
                array[res] = array[i];
                res++;
            }
        }

        printArray(array, res);
    }

    static void approachTwo(int[] array) {

        int res = 0, i;

        for (i = 0; i < array.length - 1; i++) {

            if (array[i] != array[i + 1]) {
                array[res++] = array[i];
            }
        }
        array[res++] = array[i];
        printArray(array, res);
    }
}
