package Hashing;

import java.util.HashSet;

public class CountDistinctElements extends HashingParentClass {

    // https://imgur.com/pMncshw
    public static void main(String[] args) {

        int[] array = getArray();

        System.out.println("\nCount of Distinct Elements in the array is : " + countDistinctElements(array) + "\n");
    }

    static int countDistinctElements(int[] array) {

        HashSet<Integer> hashSet = new HashSet<>();

        for (int num : array) {
            hashSet.add(num);
        }

        return hashSet.size();
    }
}
