package Arrays;

public class MaximumSumOfKElementsInArray extends ArrayParentClass {

    // O(N) Efficient approach
    public static void main(String args[]) {

        int[] array = getArray();

        System.out.println("No of consecutive elements whose maximum sum has to be found: ");
        int k = sc.nextInt();

        int max_sum = 0;

        int sum = 0;
        // First Find sum of first k elements
        for (int i = 0; i < k; i++) {
            sum += array[i];
        }
        max_sum = sum;

        // Now use sliding window approach in given sum remove first element and add
        // element next to current last element
        for (int i = 0; i < array.length - k; i++) {

            sum = sum - array[i] + array[i + k];

            if (sum > max_sum) {
                max_sum = sum;
            }
        }

        System.out.println("Maximum sum of " + k + " elements is: " + max_sum);
    }
}
