package Hashing;

import java.util.HashSet;

//Problem : https://imgur.com/twsg9g6
public class UnionOfTwoUnsortedArray extends HashingParentClass {

    public static void main(String[] args) {

        System.out.println("\n");
        int[] array1 = getArray();

        System.out.println("\n");
        int[] array2 = getArray();

        HashSet<Integer> hashSet = new HashSet<>();

        for (int i : array1) {
            hashSet.add(i);
        }

        for (int i : array2) {
            hashSet.add(i);
        }

        System.out.println("\nUnion of above unsorted array has size : " + hashSet.size());
    }
}
