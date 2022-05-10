package Arrays;

public class MaximumSumCircularSubArray extends ArrayParentClass {
    public static void main(String[] args) {

        int[] array = getArray();
        int size = array.length;

        // approachOne(array, size);

        // Image depicting concept behind this approach https://imgur.com/U2RRKJl
        // Result would be maximum of 2 things:
        // 1. Maximum sum of a Normal Subarray
        // 2. Maximum sum of a Circular Subarray which is obtained by
        // (Total Array Sum - Minimum sum SubArray)
        approachTwo(array, size);
    }

    static void approachOne(int[] array, int size) {

        int maxSum = Integer.MIN_VALUE, sum = Integer.MIN_VALUE;

        for (int i = 0; i < size; i++) {

            sum = 0;

            for (int j = 0; j < size; j++) {
                int index = (i + j) % size;

                sum = sum + array[index];

                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }

        System.out.println("Maximum Sum of Circular Sub Array is : " + maxSum);
    }

    static void approachTwo(int[] array, int size) {

        int maximumSumCircularSubArray = Math.max(getMaximumSumArray(array, size),
                getTotalArraySum(array, size) - getMinimumSumArray(array, size));

        System.out.println("Maximum sum of Circular SubArray is : " + maximumSumCircularSubArray);
    }

    static int getMaximumSumArray(int[] array, int size) {

        int maxSum[] = new int[size];

        maxSum[0] = array[0];
        for (int i = 1; i < size; i++) {

            if ((maxSum[i - 1] + array[i]) > array[i]) {
                maxSum[i] = maxSum[i - 1] + array[i];
            } else {
                maxSum[i] = array[i];
            }
        }

        int maximumSum = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            if (maxSum[i] > maximumSum) {
                maximumSum = maxSum[i];
            }
        }

        return maximumSum;
    }

    static int getMinimumSumArray(int[] array, int size) {

        int[] minSum = new int[size];

        for (int i = 1; i < size; i++) {

            if ((minSum[i - 1] + array[i]) < array[i]) {
                minSum[i] = minSum[i - 1] + array[i];
            } else {
                minSum[i] = array[i];
            }
        }

        int minimumSum = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            if (minSum[i] < minimumSum) {
                minimumSum = minSum[i];
            }
        }

        return minimumSum;
    }

    static int getTotalArraySum(int[] array, int size) {
        int totalSum = 0;

        for (int i = 0; i < size; i++) {
            totalSum += array[i];
        }

        return totalSum;
    }
}
