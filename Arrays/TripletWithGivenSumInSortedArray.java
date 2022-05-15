package Arrays;

public class TripletWithGivenSumInSortedArray extends ArrayParentClass {

    public static void main(String[] args) {

        // Sorted Array
        int[] array = getArray();

        System.out.println("\nEnter the Sum : ");
        int sum = sc.nextInt();

        findTripletWithGivenSum(array, sum);
    }

    static void findTripletWithGivenSum(int[] array, int sum) {

        for (int i = 0; i < array.length; i++) {
            int left = i + 1, right = array.length - 1;

            while (left <= right) {

                int elementsSum = array[left] + array[right] + array[i];

                if (elementsSum == sum) {
                    System.out.println("The Triplet for sum " + sum + " is " + array[i] + " , " + array[left] + " and "
                            + array[right] + "\n");
                    return;
                } else if (elementsSum < sum) {
                    left++;

                } else if (elementsSum > sum) {
                    right--;
                }

            }
        }

        System.out.println("\nNo triplet exists in the array for sum " + sum + "\n");
    }
}
