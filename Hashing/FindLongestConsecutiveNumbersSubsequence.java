package Hashing;

import java.util.HashSet;

public class FindLongestConsecutiveNumbersSubsequence extends HashingParentClass {

    public static void main(String[] args) {

        int[] array = getArray();

        System.out.println("\nLongest consecutive numbers subsequence is : " + approachOne(array) + "\n");

    }

    static int approachOne(int[] array) {

        HashSet<Integer> hashSet = new HashSet<>();

        for (int num : array) {
            hashSet.add(num);
        }

        int maxLen = 1;
        for (int i = 0; i < array.length; i++) {

            /*
             * If num-1 exists in hashSet means current num not the start of subsequence and
             * is already scanned before in max length consecutive subsequence of some
             * number below num, so we skip it
             */
            if (hashSet.contains(array[i] - 1)) {
                continue;
            }

            int count = 1;

            // Count total consecutive numbers after current count
            while (hashSet.contains(array[i] + count)) {
                count++;
            }

            if (count > maxLen) {
                maxLen = count;
            }
        }

        return maxLen;
    }
}
