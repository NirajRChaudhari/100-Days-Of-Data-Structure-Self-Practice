package Arrays;

public class LeftRotateArrayByOne extends ArrayParentClass {

    public static void main(String[] args) {

        int[] array = getArray();

        int firstElement = array[0];

        for (int i = 0; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        array[array.length - 1] = firstElement;

        printArray(array, array.length);
    }
}
