package Arrays;

public class SecondLargestElementOfArray extends ArrayParentClass {

    public static void main(String[] args) {
        int[] array = getArray();

        System.out.println("\n\nProcessing ...\n");

        int largestElement = Integer.MIN_VALUE, secondLargestElement = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > largestElement) {
                secondLargestElement = largestElement;
                largestElement = array[i];

            }

            if (array[i] < largestElement && array[i] > secondLargestElement) {
                secondLargestElement = array[i];
            }
        }

        System.out.println("Second Largest Element in the array is : " + secondLargestElement);
    }
}
