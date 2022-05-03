package Arrays;

public class MoveZeroesToEndOfArray extends ArrayParentClass {

    public static void main(String[] args) {
        int[] array = getArray();

        System.out.println("\n\nProcessing ...\n");

        // moveZeroesToEndApproachOne(array, array.length);

        // More Efficient O(n)
        moveZeroesToEndApproachTwo(array, array.length);

    }

    static void moveZeroesToEndApproachOne(int[] array, int size) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i] == 0) {
                int tempIndex = i;

                while (tempIndex + 1 < size) {
                    array[tempIndex] = array[tempIndex + 1];
                    tempIndex++;
                }
                array[size - 1] = 0;
            }
        }
        printArray(array, size);
    }

    static void moveZeroesToEndApproachTwo(int[] array, int size) {

        int countOfNonZeroElements = 0;

        for (int i = 0; i < size; i++) {

            // Ignore zeroes and replace non-zero at their proper location
            if (array[i] != 0) {
                int tempNum = array[i];
                array[i] = array[countOfNonZeroElements];
                array[countOfNonZeroElements] = tempNum;
                countOfNonZeroElements++;
            }
        }
        printArray(array, size);
    }

}
