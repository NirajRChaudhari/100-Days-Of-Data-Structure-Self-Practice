package Hashing;

import java.util.HashMap;

public class FindLongestSubarrayWithEqualNoOfOnesAndZeroes extends HashingParentClass {

    public static void main(String[] args) {

        int[] array = getArray();

        System.out.println("\nLongest Subarray with Equal number of 1's and 0's is : " + approachOne(array) + "\n");

    }

    static int approachOne(int[] array) {

        // Replace 0 with -1 so that equal no of 0(which are now -1) and 1 cancels out
        // to give prefix sum 0
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = -1;
            }
        }

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int prefixSum = array[0];
        hashMap.put(prefixSum, 0);

        int maxLen = 0;

        for (int i = 1; i < array.length; i++) {
            prefixSum = prefixSum + array[i];

            int len = 0;
            if (prefixSum == 0) {
                len = i + 1;
            }

            if (hashMap.containsKey(prefixSum)) {
                len = i - hashMap.get(prefixSum);

            } else {
                hashMap.put(prefixSum, i);
            }

            if (len > maxLen) {
                maxLen = len;
            }
        }

        return maxLen;
    }
}
