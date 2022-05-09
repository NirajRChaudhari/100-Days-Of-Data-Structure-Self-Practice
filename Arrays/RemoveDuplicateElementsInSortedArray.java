package Arrays;

public class RemoveDuplicateElementsInSortedArray extends ArrayParentClass {

    public static void main(String[] args) {
        int array[] = getArray();

        System.out.println("\n\nProcessing ...\n");

        int res = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[res - 1] != array[i]) {
                array[res] = array[i];
                res++;
            }
        }

        printArray(array, res);
    }
}
