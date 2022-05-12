package Arrays;

public class PrefixSumApproach extends ArrayParentClass {

    public static void main(String[] args) {

        int[] array = getArray();
        int size = array.length;
        char choice;
        int[] prefixSum = new int[size];

        // Do preprocessing of the array and find prefixSum in O(N) time so that all the
        // sum between 2 numbers queries can be answered in O(1) time later
        prefixSum[0] = array[0];
        for (int i = 1; i < size; i++) {
            prefixSum[i] = prefixSum[i - 1] + array[i];
        }

        do {
            System.out.println("\nFind Sum between 2 numbers ");
            System.out.print("Enter First number's index : ");
            int index1 = sc.nextInt();

            System.out.print("Enter Second number's index : ");
            int index2 = sc.nextInt();

            System.out.println();

            // Get sum in O(1) time as prefixSum is preprocessed
            int sumOfNumbers = prefixSum[index2] - prefixSum[index1] + array[index1];
            System.out.println("Sum of Numbers between these indexes is : " + sumOfNumbers + "\n");

            // Check if user want to continue
            System.out.println("Do you want to continue(Y/N) ?");
            choice = sc.next().charAt(0);
        } while (choice == 'Y' || choice == 'y');
    }
}
