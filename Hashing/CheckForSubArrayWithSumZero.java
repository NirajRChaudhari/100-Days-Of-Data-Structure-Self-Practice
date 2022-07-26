package Hashing;

import java.util.HashSet;

public class CheckForSubArrayWithSumZero extends HashingParentClass {

    // https://imgur.com/MOaQxYi
    public static void main(String[] args) {

        int[] array = getArray();

        if (approachOne(array)) {
            System.out.println("\nGiven array has a subarray with sum zero\n");

        } else {
            System.out.println("\nGiven array has NO subarray with sum zero\n");
        }

    }

    static boolean approachOne(int[] array) {

        // https://imgur.com/JuP7uBu

        HashSet<Integer> hashSet = new HashSet<>();

        int prefixSum = array[0];

        for (int i = 1; i < array.length; i++) {
            prefixSum = prefixSum + array[i];

            if (prefixSum == 0) {
                return true;
            }

            if (hashSet.contains(prefixSum)) {
                return true;
            }

            hashSet.add(prefixSum);
        }

        return false;
    }
}
