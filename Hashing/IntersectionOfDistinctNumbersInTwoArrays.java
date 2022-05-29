package Hashing;

import java.util.HashSet;
import java.util.Iterator;

public class IntersectionOfDistinctNumbersInTwoArrays extends HashingParentClass {

    public static void main(String[] args) {

        System.out.println("\n");
        int[] array1 = getArray();

        System.out.println("\n");
        int[] array2 = getArray();

        // approachOne(array1, array2);

        // More Efficient uses only one HashSet
        approachTwo(array1, array2);
    }

    static void approachOne(int[] array1, int[] array2) {

        HashSet<Integer> hashSet1 = new HashSet<>();
        HashSet<Integer> hashSet2 = new HashSet<>();

        for (int i : array1) {
            hashSet1.add(i);
        }

        for (int i : array2) {
            hashSet2.add(i);
        }

        System.out.println("\nIntersecting Distinct Numbers in Two Arrays : ");

        Iterator<Integer> itr = hashSet1.iterator();

        while (itr.hasNext()) {

            int num = itr.next();

            if (hashSet2.contains(num)) {
                System.out.print(num + "  ");
            }
        }
        System.out.println("\n");
    }

    static void approachTwo(int[] array1, int[] array2) {

        HashSet<Integer> hashSet = new HashSet<>();

        for (int num : array1) {
            hashSet.add(num);
        }

        System.out.println("\nIntersecting Distinct Numbers in Two Arrays : ");
        for (int num : array2) {

            if (hashSet.contains(num)) {

                System.out.print(num + " ");

                /*
                 * It's important to remove this intersecting element from array1 so that it's
                 * printed only once irrespective if the same number exists in array2 multiple
                 * times
                 */
                hashSet.remove(num);
            }
        }
        System.out.println("\n\n");
    }
}
