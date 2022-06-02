package Hashing;

import java.util.HashSet;

public class PariWithGivenSumInUnsortedArray extends HashingParentClass {

    public static void main(String[] args) {

        int[] array = getArray();

        System.out.println("\nEnter the expected sum of pair : ");
        int sum = sc.nextInt();

        HashSet<Integer> hashSet = new HashSet<>();

        /*
         * Very Imp for array =[11,5,6] and sum = 10
         * Answer Pair should not be 5,5
         */
        for (int i = 0; i < array.length; i++) {

            if (hashSet.contains(sum - array[i])) {
                System.out.println(
                        "\nPair having sum : " + sum + " in the array is (" + array[i] + "," + (sum - array[i])
                                + ")\n");

                return;
            }

            hashSet.add(i);
        }

        System.out.println("\nNo pair exists in the array with sum : " + sum + "\n");
    }
}
