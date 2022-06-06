package Hashing;

import java.util.HashMap;

// Print numbers with count N/K where K is input and N is size
public class PrintElementsHavingCountNDivideByK extends HashingParentClass {

    public static void main(String[] args) {

        int[] array = getArray();

        System.out.println("\nEnter the value of k :");
        int k = sc.nextInt();

        approachOne(array, k);
    }

    static void approachOne(int[] array, int k) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        System.out.println("\nElement having count more than N/K : ");
        for (int num : array) {

            // num qualifies as >N/K and is already printed once
            if (hashMap.get(num) != null && hashMap.get(num) == -1) {
                continue;
            }

            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);

            if (hashMap.get(num) > (array.length / k)) {
                System.out.println(num + "  ");

                // Assign -1 to indicate num already printed once
                hashMap.put(num, -1);
            }
        }

        System.out.println("\n");
    }
}
