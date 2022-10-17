package Recursion;

public class SubsetsWithGivenSumInArray extends RecursionParentClass {

    public static void main(String[] args) {

        int[] array = getArray();

        System.out.println("\nEnter the Sum : ");
        int inputSum = sc.nextInt();

        System.out.println("\nTotal No. of subsets with sum " + inputSum + " are : "
                + getTotalNoOfSubsetsWithGivenSum(array, inputSum, 0) + "\n");

    }

    static int getTotalNoOfSubsetsWithGivenSum(int[] array, int inputSum, int index) {

        if (inputSum == 0) {
            return 1;
        }

        if (index == array.length || inputSum < 0) {
            return 0;
        }

        return getTotalNoOfSubsetsWithGivenSum(array, inputSum, index + 1)
                + getTotalNoOfSubsetsWithGivenSum(array, inputSum - array[index], index + 1);
    }
}
