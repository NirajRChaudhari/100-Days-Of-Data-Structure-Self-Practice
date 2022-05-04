package Arrays;

public class PairWithGivenSumInSortedArray extends ArrayParentClass {

    public static void main(String[] args) {

        // Sorted Array
        int[] array = getArray();

        System.out.println("\nEnter the sum : ");
        int sum = sc.nextInt();

        findPairWithGivenSum(array, sum);
    }

    static void findPairWithGivenSum(int[] array, int sum) {

        int left = 0, right = array.length - 1;

        while (left <= right) {

            int elementsSum = array[left] + array[right];

            if (elementsSum == sum) {
                System.out
                        .println("\nPair of elements with sum " + sum + " are " + array[left] + " and " + array[right]
                                + "\n");
                return;

            } else if (elementsSum < sum) {
                left++;

            } else if (elementsSum > sum) {
                right--;
            }
        }

        System.out.println("\nTheir is no pair of elements with sum " + sum + " in the given sorted array\n");
    }
}
