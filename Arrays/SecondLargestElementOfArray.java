package Arrays;

public class SecondLargestElementOfArray extends ArrayParentClass {

    public static void main(String[] args) {
        int[] array = getArray();

        System.out.println("\n\nProcessing ...\n");

        // approachOne(array);
        approachTwo(array);
    }

    static void approachOne(int[] array) {
        int largestElement = Integer.MIN_VALUE, secondLargestElement = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > largestElement) {
                secondLargestElement = largestElement;
                largestElement = array[i];

            }

            else if (array[i] < largestElement && array[i] > secondLargestElement) {
                secondLargestElement = array[i];
            }
        }

        System.out.println("Second Largest Element in the array is : " + secondLargestElement + "\n\n");
    }

    static void approachTwo(int[] array) {

        int largestElement = Integer.MIN_VALUE;
        int secondLargestElement = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {

            // array[i] != largestElement condition is imp or else for arr[] = {20,10,20}
            // largest and secondLargest both will be 20
            if (array[i] > secondLargestElement && array[i] != largestElement) {
                secondLargestElement = array[i];
            }

            if (secondLargestElement > largestElement) {
                int tempNum = secondLargestElement;
                secondLargestElement = largestElement;
                largestElement = tempNum;
            }
        }

        System.out.println("Second Largest Element in the array is : " + secondLargestElement + "\n\n");
    }
}
