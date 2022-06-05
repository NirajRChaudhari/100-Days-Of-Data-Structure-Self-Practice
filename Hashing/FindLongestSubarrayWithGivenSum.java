package Hashing;

import java.util.HashMap;

// Problem : https://imgur.com/UgND8uS
public class FindLongestSubarrayWithGivenSum extends HashingParentClass {

    public static void main(String[] args) {

        int[] array = getArray();

        System.out.println("\nEnter the desired sum : ");
        int sum = sc.nextInt();

        System.out.println("\nLongest Subarray with given sum is of size : " + approachOne(array, sum) + "\n");
    }

    static int approachOne(int[] array, int sum) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int[] prefixSum = new int[array.length];
        prefixSum[0] = array[0];
        hashMap.put(prefixSum[0], 0);

        int maxLen = 0;
        for (int i = 1; i < array.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + array[i];

            int res = 0;
            if (prefixSum[i] == sum) {
                res = i + 1;
            }

            if (hashMap.containsKey(prefixSum[i] - sum)) {
                res = i - hashMap.get(prefixSum[i] - sum);
            }

            if (!hashMap.containsKey(prefixSum[i])) {
                hashMap.put(prefixSum[i], i);
            }

            if (res > maxLen) {
                maxLen = res;
            }
        }

        return maxLen;
    }
}
