package Arrays;

public class MaximumSumSubArray_KadaneAlgorithm extends ArrayParentClass {

    public static void main(String[] args) {

        int[] array = getArray();
        int size = array.length;

        // Create all possible sub arrays and find their sum O(n^2)
        // approachOne(array, size);

        // Efficient O(n) Kadane's Approach
        approachTwo(array, size);
    }

    static void approachOne(int[] array, int size) {

        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < size; i++) {
            int sum = 0;

            for (int j = i; j < size; j++) {
                sum += array[j];

                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }

        System.out.println("Maximum Sum of SubArray is : " + maxSum);
    }

    static void approachTwo(int[] array, int size) {

        int maxSumArray[] = new int[size];

        maxSumArray[0] = array[0];
        for (int i = 1; i < size; i++) {

            if ((maxSumArray[i - 1] + array[i]) > array[i]) {
                maxSumArray[i] = maxSumArray[i - 1] + array[i];
            } else {
                maxSumArray[i] = array[i];
            }
        }

        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            if (maxSumArray[i] > maxSum) {
                maxSum = maxSumArray[i];
            }
        }

        System.out.println("Maximum Sum of SubArray is : " + maxSum);
    }
}
