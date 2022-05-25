package Arrays;

public class MaximumDifference extends ArrayParentClass {
    // Maximum value of arr[j]-arr[i] such that j>i

    public static void main(String[] args) {

        int array[] = getArray();

        int maxDifference = Integer.MIN_VALUE, difference = 0;
        int smallest = array[0];

        for (int i = 1; i < array.length; i++) {
            difference = array[i] - smallest;

            if (difference > maxDifference) {
                maxDifference = difference;
            }

            if (array[i] < smallest) {
                smallest = array[i];
            }
        }

        System.out.println("Maximum Difference is : " + maxDifference);
    }

}
