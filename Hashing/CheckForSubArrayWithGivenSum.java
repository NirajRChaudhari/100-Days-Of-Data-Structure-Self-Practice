package Hashing;

import java.util.HashSet;

// Problem : https://imgur.com/ibEFTMB
public class CheckForSubArrayWithGivenSum extends HashingParentClass {

    public static void main(String[] args) {

        int[] array = getArray();

        System.out.println("\nEnter the desired sum : ");
        int sum = sc.nextInt();

        if (approachOne(array, sum)) {
            System.out.println("\nGiven array has a subarray with sum " + sum + "\n");

        } else {
            System.out.println("\nGiven array has NO subarray with sum " + sum + "\n");
        }
    }

    static boolean approachOne(int[] array, int sum) {

        HashSet<Integer> hashSet = new HashSet<>();

        int prefixSum = array[0];

        for (int i = 1; i < array.length; i++) {
            prefixSum = prefixSum + array[i];

            if (prefixSum == sum) {
                return true;
            }

            if (hashSet.contains(prefixSum - sum)) {
                return true;
            }

            hashSet.add(prefixSum);
        }

        return false;
    }
}
