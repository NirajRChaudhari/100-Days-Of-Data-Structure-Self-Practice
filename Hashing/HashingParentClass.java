package Hashing;

import java.util.Scanner;

public class HashingParentClass {

    /*
     * Hashing has time complexity of O(1) for Insert, Search and Delete
     * 
     * Hashing is not recommended for:
     * 1. Finding Closest value - Use RedBlack or AVL Tree
     * 2. Any operation related to Sorted data - Use RedBlack or AVL Tree
     * 3. Prefix Matching or Searching - Use Trie
     * 
     * When operations on stored data like find closest, largest, smallest value,
     * etc then Hashing isn't that usefull as it does not maintain relationship
     * between data while storing it instead stores each value independent of other
     * 
     * In a Hash function, always try to use prime value greater than N (Total
     * possible keys)
     * eg, hashFunction = num % k;
     * k > N(Total possible keys) and k should be Prime
     * as 2^m value of k matches last m bits of the number as a hash function
     * and 10^m value of k matches last m digits of the number as a hash function
     */

    // There is difference between SubArray and SubSequence

    static Scanner sc = new Scanner(System.in);

    protected static int[] getArray() {
        System.out.println("Please enter the size of the array: ");
        int size = sc.nextInt();

        int[] array = new int[size];

        System.out.println("Enter the values of the array: ");
        for (int i = 0; i < size; i++) {
            array[i] = sc.nextInt();
        }

        return array;
    }
}
